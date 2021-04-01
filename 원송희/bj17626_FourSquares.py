import sys

num=int(sys.stdin.readline())
dp=[5]*(num+1) #최대 4라고 했으니까 그냥 설정
dp[0]=0
dp[1]=1
for i in range(2, num+1, 1):
    for j in range(1, int(num**0.5)+1, 1):
        dp[i]=min(dp[i], dp[i-j**2]+1)
print(dp[num])
