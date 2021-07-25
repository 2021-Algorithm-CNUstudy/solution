import sys
N=int(sys.stdin.readline())
info=[]
for i in range(N):
    temp=sys.stdin.readline().rstrip()
    temp=temp.split(" ")
    name=temp[0]
    day=int(temp[1])
    month=int(temp[2])
    year=int(temp[3])
    info.append([name, year, month, day])
info.sort(key=lambda x:(x[1], x[2], x[3]))
print(info[N-1][0])
print(info[0][0])
