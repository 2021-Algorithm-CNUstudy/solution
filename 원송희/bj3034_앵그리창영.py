import sys
temp=sys.stdin.readline().rsplit()
N=int(temp[0])
W=int(temp[1])
H=int(temp[2])
max_sqr=W*W+H*H
for i in range(N):
    length=int(sys.stdin.readline())
    if max_sqr>=length*length:
        print("DA")
    else:
        print("NE")
