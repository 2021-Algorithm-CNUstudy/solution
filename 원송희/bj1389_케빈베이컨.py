from sys import stdin
import sys

temp=stdin.readline().split(' ')
N=int(temp[0])
M=int(temp[1])
#기본은 무한대 처리
arr=[[sys.maxsize for col in range(N)] for row in range(N)]

for i in range(N):
    #자기 자신은 0 처리
    arr[i][i]=0

for _ in range(M):
    #친구로 주어진 경우 체크
    temp=stdin.readline().split(' ')
    num1=int(temp[0])
    num2=int(temp[1])
    arr[num1-1][num2-1]=1
    arr[num2-1][num1-1]=1

for i in range(N):
    for j in range(N):
        for k in range(N):
            if j==k:
                #이미 체크한 경우
                continue
            else:
                if arr[j][k] > arr[j][i]+arr[i][k]:
                    arr[j][k]=arr[j][i]+arr[i][k]

sum=[]
for i in range(N):
    temp=0
    for j in range(N):
        temp+=arr[i][j]
    sum.append(temp)
min=min(sum)
print(sum.index(min)+1)
