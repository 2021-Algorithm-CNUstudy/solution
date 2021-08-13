import sys
N=int(sys.stdin.readline())
if N==1:
    print(10)
elif N==2:
    print(55)
else:
    dp=[[0]*10 for _ in range(N+1)]
    dp[0]=[1]*10
    dp[1]=[i for i in range(1, 11)]
    for i in range(2, N+1):
        for j in range(10):
            dp[i][j]=sum(dp[i-1][:j+1])
    print(dp[N][9]%10007)
