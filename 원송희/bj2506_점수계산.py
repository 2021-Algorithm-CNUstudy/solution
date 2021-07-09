import sys
N=int(sys.stdin.readline())
temp=sys.stdin.readline().rsplit()
score=list(map(int, temp))
answer=0
plus=1
for i in range(N):
    if score[i]==1:
        answer+=plus
        plus+=1
    else:
        plus=1
print(answer)
