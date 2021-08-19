import sys
N=int(sys.stdin.readline())
B=1
A=N-B
found=False
while B<87654 and A>0:
    temp=str(A)+str(B)
    if len(temp)==len(set(temp)):
        found=True
        print(A, "+", B)
        break
    B+=1
    A=N-B
if found==False:
    print(-1)
