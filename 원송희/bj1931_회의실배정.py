import sys
N=int(sys.stdin.readline())
schedule=[]
for _ in range(N):
    start, end=map(int, sys.stdin.readline().split(" "))
    schedule.append([start, end])
schedule.sort(key=lambda x:(x[1], x[0]))
answer=1
next_empty_time=schedule[0][1]
for i in range(1, N):
    if schedule[i][0]>=next_empty_time:
        answer+=1
        next_empty_time=schedule[i][1]
print(answer)
