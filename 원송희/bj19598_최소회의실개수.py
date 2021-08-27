import sys
time_table=[]
N=int(sys.stdin.readline())
for i in range(N):
    temp=sys.stdin.readline().split(" ")
    start=int(temp[0])
    end=int(temp[1])
    time_table.append([start, "start"])
    time_table.append([end, "end"])
time_table.sort(key=lambda x:(x[0], x[1]))
answer=0
room=0
for time, start_or_end in time_table:
    if start_or_end=="start":
        room+=1
    elif start_or_end=="end":
        room-=1
    answer=max(answer, room)
print(answer)
