import sys
N=int(sys.stdin.readline())
for i in range(N):
    temp=sys.stdin.readline().rstrip()
    temp=temp.split(" ")
    number=list(map(int, temp))
    number.sort()
    print(number[-3])
