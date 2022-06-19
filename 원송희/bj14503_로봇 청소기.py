import sys

N, M = map(int, sys.stdin.readline().split(" "))
r, c, d = map(int, sys.stdin.readline().split(" "))
board = [[0] * M for _ in range(N)]
for i in range(N):
    board[i] = list(map(int, sys.stdin.readline().split(" ")))
visited = [[False] * M for _ in range(N)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
visited[r][c] = True
answer = 1

while 1:
    flag = False
    for i in range(4):
        next_x = r + dx[(d + 3) % 4]
        next_y = c + dy[(d + 3) % 4]
        d = (d + 3) % 4
        if 0 <= next_x < N and 0 <= next_y < M and board[next_x][next_y] == 0:
            if visited[next_x][next_y] == False:
                visited[next_x][next_y] = True
                answer += 1
                r = next_x
                c = next_y
                flag = True
                break
    if not flag:
        if board[r - dx[d]][c - dy[d]] == 1:
            print(answer)
            break
        else:
            r -= dx[d]
            c -= dy[d]
