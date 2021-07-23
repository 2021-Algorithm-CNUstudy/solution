import sys
temp=sys.stdin.readline()
A=sys.stdin.readline().split(" ")
A=list(map(int, A))
B=sys.stdin.readline().split(" ")
B=list(map(int, B))
arr=[]
arr=A+B
arr.sort()
for item in arr:
    print(item, end=" ")
