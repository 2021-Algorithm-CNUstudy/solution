import sys
temp=sys.stdin.readline().split(" ")
temp=list(map(int, temp))
country=temp[0]
country_to_find=temp[1]
info=[]
for _ in range(country):
    temp=sys.stdin.readline().split(" ")
    temp=list(map(int, temp))
    info.append(temp)
info.sort(key=lambda x:(-x[1], -x[2], -x[3]))
rank=0
keep_rank=1
for idx in range(len(info)):
    if info[idx][1:4]==info[idx-1][1:4]:
        info[idx].append(rank)
        keep_rank+=1
    else:
        rank+=keep_rank
        info[idx].append(rank)
        keep_rank=1
for i in info:
    if i[0]==country_to_find:
        print(i[4])
        break
