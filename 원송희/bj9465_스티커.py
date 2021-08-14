import sys
T=int(sys.stdin.readline())
for _ in range(T):
    N=int(sys.stdin.readline())
    dp=[[0]*N for _ in range(2)]
    for i in range(2):
        temp=sys.stdin.readline().split(" ")
        temp=list(map(int, temp))
        dp[i]=temp
    if N==1:
        print(max(dp[0][0], dp[1][0]))
    elif N==2:
        print(max(dp[0][0]+dp[1][1], dp[0][1]+dp[1][0]))
    else:
        dp[0][1]+=dp[1][0]
        dp[1][1]+=dp[0][0]
        for i in range(2, N):
            dp[0][i]+=max(dp[1][i-2], dp[1][i-1])
            dp[1][i]+=max(dp[0][i-2], dp[0][i-1])
        print(max(dp[0][N-1], dp[1][N-1]))
