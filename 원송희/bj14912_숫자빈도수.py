import sys
temp=sys.stdin.readline().split(" ")
N=int(temp[0])
M=temp[1].rstrip()
num=[]
for i in range(N):
    num.append(str(i+1))
answer="".join(num)
print(answer.count(M))
