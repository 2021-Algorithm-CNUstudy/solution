import sys
temp=sys.stdin.readline().split(" ")
n=int(temp[0])
r=int(temp[1])
dp=[[1]*1001 for _ in range(1001)]
dp[1][1]=1
for i in range(0, 1001):
    dp[i][i]=1
    dp[i][1]=i
for i in range(2, n+1):
    for j in range(1, i):
        dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%10007
print(dp[n][r])
