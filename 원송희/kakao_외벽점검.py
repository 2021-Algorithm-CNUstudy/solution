from itertools import permutations

def solution(n, weak, dist):
    returnList=[] #마지막에 최솟값 비교할 것임 (모든 cnt 저장 리스트)
    length=len(weak)
    LinearWeak=weak #선형으로 변경 (n을 더해줌으로써)
    for i in range(len(weak)):
        LinearWeak.append(n+weak[i])
    checkList=[] #여기서 체크 위치 뽑아가면 됨
    for i in range(length):
        temp=[]
        for j in range(length):
            temp.append(weak[i+j])
        checkList.append(temp) #탐색할 곳 리스트
    friends=list(permutations(dist)) #친구 순서 리스트
    for i, check in enumerate(checkList):
        startPoint=check[0] #시작점
        endPoint=check[len(check)-1] #종료점
        for order in friends: #모든 순열에서
            cnt = 1
            where = startPoint #현재 위치
            for dis in order: #해당 순열 순서대로 친구를 뽑아옴
                where+=dis #갈 수 있는 거리 더하고
                if where<endPoint: #도착 못했으면
                    cnt+=1 #한 명 더 데리고 와야함
                    for k in range(0, len(checkList[i]), 1): #그런데 도달한 점은 뺄 거니까
                        if where >= checkList[i][k]: #도달 못 했지만 가장 가까운 취약점 탐색
                            continue
                        else: #가장 가까운 도달 못 한 점 발견
                            where = checkList[i][k] #거기로 이동
                            break
                else:
                    returnList.append(cnt) #cnt 추가
    if not returnList: #비어있는 리스트이면 모든 케이스에서 도착을 못 했다는 뜻
        return -1 
    else: #종료점까지 도달은 했다면
        return min(returnList) #최소 친구 수 리턴
