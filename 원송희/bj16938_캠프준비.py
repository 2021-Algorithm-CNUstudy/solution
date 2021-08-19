import sys
from itertools import combinations
temp=sys.stdin.readline().split(" ")
N=int(temp[0])
L=int(temp[1])
R=int(temp[2])
X=int(temp[3])
level=list(map(int, sys.stdin.readline().split(" ")))
answer=0
for i in range(2, len(level)+1):
    for c in combinations(level, i):
        temp=list(c)
        temp.sort()
        if L<=sum(temp)<=R and temp[-1]-temp[0]>=X:
            answer+=1
print(answer)
