import sys
from itertools import combinations_with_replacement
temp=sys.stdin.readline().rsplit()
N=int(temp[0])
M=int(temp[1])
num=[]
for i in range(1, N+1, 1):
    num.append(i)
combi=list(combinations_with_replacement(num, M))
for c in combi:
    c=list(c)
    for l in c:
        print(l, end=" ")
    print()
