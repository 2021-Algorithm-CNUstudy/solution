from sys import stdin

T=int(stdin.readline())

for i in range(T):
    temp=stdin.readline().split(' ')
    M=int(temp[0])
    N=int(temp[1])
    x=int(temp[2])
    y=int(temp[3])
    result=-1
    while (x<M*N+1):
        if x%N==y%N:
            result=x
            break
        x+=M
    print(result)
