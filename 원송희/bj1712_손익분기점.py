import sys
temp=sys.stdin.readline().rstrip().split(" ")
A=int(temp[0])
B=int(temp[1])
C=int(temp[2])
if B>=C:
    print(-1)
else:
    print(int(A/(C-B))+1)
