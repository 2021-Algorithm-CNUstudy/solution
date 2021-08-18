import sys
temp=sys.stdin.readline().split(" ")
N=int(temp[0])
M=int(temp[1])
num_arr=[]
for i in range(N):
    temp=sys.stdin.readline().split(" ")
    temp=list(map(int, temp))
    num_arr.append(temp)
sum_arr=[[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if j==0:
            sum_arr[i][j]=num_arr[i][j]
            continue
        sum_arr[i][j]=sum_arr[i][j-1]+num_arr[i][j]
for i in range(M):
    temp=sys.stdin.readline().split(" ")
    x1=int(temp[0])
    y1=int(temp[1])
    x2=int(temp[2])
    y2=int(temp[3])
    answer=0
    for j in range(x1-1, x2):
        if y1!=1:
            answer-=sum_arr[j][y1-2]
        answer+=sum_arr[j][y2-1]
    print(answer)
