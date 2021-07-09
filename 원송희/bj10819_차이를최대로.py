import sys
from itertools import permutations
N=int(sys.stdin.readline())
num=sys.stdin.readline().rsplit()
num=list(map(int, num))
temp=[]
for i in range(N):
    temp.append(i)
permu=list(permutations(temp, N))
sum_list=[]
for p in permu:
    idx=list(p)
    temp=[]
    for i in range(len(idx)):
        temp.append(num[idx[i]])
    sum=0
    for i in range(1, len(temp)):
        sum+=abs(temp[i]-temp[i-1])
    sum_list.append(sum)
print(max(sum_list))
