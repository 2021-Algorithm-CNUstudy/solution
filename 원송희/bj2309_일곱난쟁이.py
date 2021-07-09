import sys
from itertools import combinations
height=[]
for i in range(9):
    height.append(int(sys.stdin.readline()))
combi=list(combinations(height, 7))
answer=[]
for c in combi:
    if sum(c)==100:
        answer=c
        break
answer=list(answer)
answer.sort()
for i in range(len(answer)):
    print(answer[i])
