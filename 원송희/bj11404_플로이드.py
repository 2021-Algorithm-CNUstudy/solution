import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
INF = int(1e9)
floyd = [[INF] * (N+1) for _ in range(N+1)]
for _ in range(M):
    temp = list(map(int, sys.stdin.readline().split(" ")))
    floyd[temp[0]][temp[1]] = min(floyd[temp[0]][temp[1]], temp[2])

for k in range(1, N+1): # 중간에 거치는 점
    for i in range(1, N+1): # 시작점
        for j in range(1, N+1): # 종료점
            if i==j:
                floyd[i][j]=INF
            elif floyd[i][j]>floyd[i][k]+floyd[k][j]:
                floyd[i][j] = floyd[i][k]+floyd[k][j]

for i in range(N+1):
    for j in range(N+1):
        if floyd[i][j]==INF:
            floyd[i][j]=0

for i in range(1, N+1):
    answer = floyd[i][1:]
    answer = list(map(str, answer))
    print(" ".join(answer))
