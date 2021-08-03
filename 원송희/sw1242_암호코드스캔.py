import sys
def correct_code(decoded_code, visited): # 알맞은 검증 코드를 사용하였는지 확인
    code=list(decoded_code)
    code=list(map(int, code))
    if ((code[0]+code[2]+code[4]+code[6])*3+code[1]+code[3]+code[5]+code[7])%10==0 \
            and decoded_code not in visited:
        visited.append(decoded_code)
        return True
    return False

def hex_to_bi(N, code): # 16진수 -> 2진수
    hex2bi={"0":"0000", "1":"0001", "2":"0010", "3":"0011",
            "4":"0100", "5":"0101", "6":"0110", "7":"0111",
            "8":"1000", "9":"1001", "A":"1010", "B":"1011",
            "C":"1100", "D":"1101", "E":"1110", "F":"1111"}
    for line in range(N):
        temp=""
        for ch in code[line]:
            temp+=hex2bi[ch]
        code[line]=temp
    return code

def decode(N, M, code): # 암호 해독기
    decoder={"[2, 1, 1]": "0", "[2, 2, 1]": "1", "[1, 2, 2]": "2", "[4, 1, 1]": "3",
             "[1, 3, 2]": "4", "[2, 3, 1]": "5", "[1, 1, 4]": "6", "[3, 1, 2]": "7",
             "[2, 1, 3]": "8", "[1, 1, 2]": "9"}
    # [2, 1, 1]이라는 것은 앞의 0의 개수는 모르지만 n:2:1:1 비율로 0, 1, 0, 1이 존재한다는 것
    after_decode=[]
    for line in range(N):
        result=""
        temp=code[line][::-1] # 뒤집어서 판별 (왜인지는 아래 써놓음)
        if "1" not in temp: # 1이 없으면 볼 이유도 없음
            continue
        # 테두리가 0으로 되어있기 때문에 어디가 암호의 시작인지 알 수 없지만 (ㅈㄴ고민함)
        # 확실한 것은 암호는 1로 끝나기 때문에 암호의 끝은 찾을 수 있음!!
        # 그러면 두께도 알 수 있는데 끝에서부터 0->1->0->1->0로 변하는 index를 저장하면 됨
        # 두께가 중요한 이유는 문제에서 가장 얇은 경우 1이지만 두꺼워질 경우,
        # 1:2이면 두께가 3:6, 5:10 .. 등등 될 수 있다고 조건에 주어졌기 때문임
        # 그러므로 두께를 구하기 위해 숫자가 변하는 index를 총 4번 저장 (화살표 부분)
        # 0->1->0->1->0 화살표 부분이 각각 idx1, idx2, idx3, idx4
        # 유의할 점은 뒤집어진 문자열이므로 idx1>idx2>idx3>idx4 순이라는 것!
        idx1=0 # 0->1
        idx2=0 # 1->0
        idx3=0 # 0->1
        idx4=0 # 1->0
        real_idx=0
        for ch in temp:
            if ch=="1" and idx1==0 and idx2==0 and idx3==0 and idx4==0:
                idx1=4*M-1-real_idx # 16진수에서 2진수로 바꿨으므로 길이는 4배가 되었음
            elif ch=="0" and idx1!=0 and idx2==0 and idx3==0 and idx4==0:
                idx2=4*M-1-real_idx
            elif ch=="1" and idx1!=0 and idx2!=0 and idx3==0 and idx4==0:
                idx3=4*M-1-real_idx
            elif ch=="0" and idx1!=0 and idx2!=0 and idx3!=0 and idx4==0:
                idx4=4*M-1-real_idx
                width=[] # 두께를 저장하기 위한 배열
                width.append(idx1-idx2) # 2번째 1 두께
                width.append(idx2-idx3) # 2번째 0 두께
                width.append(idx3-idx4) # 1번째 1 두께
                # 1번째 0두께는 중요하지 않음 (구할 수도 없고!)
                if min(width)!=1: # 비율이 n:m:k일 경우 기약분수로 나타내야함
                    minimum=min(width) # 무조건 작은걸로 나누어 떨어짐
                    for i in range(len(width)): # 모든 비율은 1:n:m 이니까
                        width[i]=width[i]//minimum
                width.reverse() # 거꾸로 해석했으니까 다시 뒤집어서 넣은 후
                result+=decoder[str(width)] # 해독기(dictionary)에 돌림
                idx1=0 # 초기화
                idx2=0
                idx3=0
                idx4=0
            real_idx+=1 #
        after_decode.append(result[::-1]) # temp는 뒤집어진 상태였으므로 다시 뒤집어서 추가
    return after_decode

T=int(sys.stdin.readline())
for i in range(T):
    temp=sys.stdin.readline().split(" ")
    N=int(temp[0])
    M=int(temp[1])
    code=[list(sys.stdin.readline().rstrip()) for _ in range(N)]
    code=hex_to_bi(N, code) # 2진수로 변환시키고
    answer=0
    decoded_code=decode(N, M, code) # 해독기 돌려서 원래 값 알아냄
    visited=[] # 나중에 다시 읽어보니까 이미 해독한 코드는 answer에 더하는게 아니더라...
    for dec in decoded_code: # 이제 알맞은 검증 코드인지 확인
        if correct_code(dec, visited): # 알맞은 검증 코드이면
            answer+=sum(list(map(int,dec))) # 값을 더함
    print("#", end="")
    print(i+1, answer)
