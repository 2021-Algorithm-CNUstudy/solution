import sys
from itertools import product
temp=sys.stdin.readline().split(" ")
N=int(temp[0])
M=int(temp[1])
num=[]
for i in range(1, N+1, 1):
    num.append(i)
combi=list(product(num, repeat=M))
for c in combi:
    c=list(c)
    for l in c:
        print(l, end=" ")
    print()
