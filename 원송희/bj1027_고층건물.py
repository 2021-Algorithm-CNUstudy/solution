import sys
N=int(sys.stdin.readline())
temp=sys.stdin.readline().split(" ")
building=list(map(int, temp))
cnt=[0 for i in range(N)]
for i in range(N):
    maximum=-1e9
    for j in range(i+1, N):
        scope=(building[j]-building[i])/(j-i)
        if maximum<scope:
            maximum=scope
            cnt[i]+=1
            cnt[j]+=1
print(max(cnt))
