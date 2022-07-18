import sys
while(1):
    A=int(sys.stdin.readline())
    if A==0:
        break
    answer=0
    # A*A=C*C-B*B=(C+B)*(C-B)
    # (C+B)와 (C-B)는 A의 약수
    for B in range(1, A):
        if (A*A)%B!=0:
            continue
        C=A*A//B
        if (C+B)%2==0 and (C-B)//2>A:
            answer+=1
    print(answer)
