import sys

N=int(sys.stdin.readline())
vote=[]
dasom=int(sys.stdin.readline())
if N==1:
    print(0)
else:
    for i in range(N-1):
        vote.append(int(sys.stdin.readline()))

    if dasom>max(vote):
        print(0)
    else:
        cnt=0
        while max(vote)>=dasom:
            vote.sort(reverse=True)
            vote[0]-=1
            dasom+=1
            cnt+=1
        print(cnt)
