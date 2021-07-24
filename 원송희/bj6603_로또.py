import sys
from itertools import combinations
while(1):
    temp=sys.stdin.readline().split(" ")
    if temp==['0\n']:
        break
    number=list(map(int, temp))
    number=number[1:]
    combi=list(combinations(number, 6))
    for c in combi:
        for i in c:
            print(i, end=" ")
        print()
    print()
