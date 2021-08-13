import sys
N=int(sys.stdin.readline())
temp=sys.stdin.readline().split(" ")
number=list(map(int, temp))
dp=[1 for _ in range(N)]
for i in range(N):
    for j in range(i):
        if number[i]<number[j]:
            dp[i]=max(dp[i], dp[j]+1)
print(max(dp))
