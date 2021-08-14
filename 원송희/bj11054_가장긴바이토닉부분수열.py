import sys
N=int(sys.stdin.readline())
temp=sys.stdin.readline().split(" ")
number=list(map(int, temp))
dp_inc=[1 for _ in range(N)]
dp_dec=[1 for _ in range(N)]
for i in range(N):
    for j in range(i):
        if number[N-i-1]>number[N-j-1]: # 감소
            dp_dec[N-i-1]=max(dp_dec[N-i-1], dp_dec[N-j-1]+1)
        if number[i]>number[j]:
            dp_inc[i]=max(dp_inc[i], dp_inc[j]+1)
dp=[0 for _ in range(N)]
for i in range(N):
    dp[i]=dp_inc[i]+dp_dec[i]
print(max(dp)-1)
