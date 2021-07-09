import sys
N=int(sys.stdin.readline())
idx=sys.stdin.readline().rsplit()
idx=list(map(int, idx))
answer=[]
for i in range(N):
    answer.insert(idx[i], i+1)
answer.reverse()
for i in range(N):
    print(answer[i], end=" ")
