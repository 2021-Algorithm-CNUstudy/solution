import sys
temp=sys.stdin.readline().split(" ")
H=int(temp[0])
W=int(temp[1])
wall=list(map(int, sys.stdin.readline().split(" ")))
answer=0
for i in range(1, W-1):
    left_max=max(wall[:i])
    right_max=max(wall[i+1:])
    if min(left_max, right_max)>wall[i]:
        answer+=min(left_max, right_max)-wall[i]
print(answer)
