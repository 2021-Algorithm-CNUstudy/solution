import sys
N=int(sys.stdin.readline())
name=[]
name2=[]
name3=[]
for i in range(N):
    temp=sys.stdin.readline().rstrip()
    name.append(temp)
    name2.append(temp)
    name3.append(temp)
name2.sort()
name3.sort(reverse=True)
if name==name2:
    print("INCREASING")
elif name==name3:
    print("DECREASING")
else:
    print("NEITHER")
