import sys
import math
N, M, K=map(int, sys.stdin.readline().split(" "))
word_cnt=math.factorial(N+M)//(math.factorial(N)*math.factorial(M))
if K>word_cnt:
    print(-1)
else:
    K-=1
    answer=""
    while(1):
        if N==0 or M==0:
            break
        temp=math.factorial(N+M-1)//(math.factorial(N-1)*math.factorial(M))
        if K<temp:
            answer+="a"
            N-=1
        else:
            answer+="z"
            M-=1
            K-=temp
    if N==0 and M!=0:
        answer+="z"*M
    elif N!=0 and M==0:
        answer+="a"*N
    print(answer)
