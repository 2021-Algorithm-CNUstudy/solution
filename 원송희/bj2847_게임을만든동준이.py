import sys
N=int(sys.stdin.readline())
score=[]
for i in range(N):
    temp=int(sys.stdin.readline())
    score.append(temp)
cnt=0
for i in range(N-1, 0, -1):
    if score[i-1]>=score[i]:
        while score[i-1]>=score[i]:
            score[i-1]-=1
            cnt+=1
print(cnt)
