import sys

T = int(sys.stdin.readline())
for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().split(" "))
    distance = (((x2 - x1) ** 2) + ((y2 - y1) ** 2)) ** 0.5
    radius_sum = r1 + r2
    if distance == 0 and r1 == r2:
        print(-1)
    elif abs(r1 - r2) == distance or r1 + r2 == distance:
        print(1)
    elif abs(r1 - r2) < distance < r1 + r2:
        print(2)
    else:
        print(0)
