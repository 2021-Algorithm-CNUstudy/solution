import sys
N=int(sys.stdin.readline())
temp=sys.stdin.readline().split(" ")
num=[]
for i in temp:
    num.append(int(i))
set_num=set(num)
print(len(num)-len(set_num))
