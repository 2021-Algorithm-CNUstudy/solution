import sys
N=int(sys.stdin.readline())
temp=sys.stdin.readline().split(" ")
number=list(map(int, temp))
dp=number[:]
to_compare=0
for i in range(N):
    max_int=0
    for j in range(i):
        if number[i]<number[j]:
            if max_int<dp[j]:
                max_int=dp[j]
    dp[i]=max_int+number[i]
    if to_compare<dp[i]:
        to_compare=dp[i]
print(max(dp))
