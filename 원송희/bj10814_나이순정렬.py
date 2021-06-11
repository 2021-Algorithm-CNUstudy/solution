N=int(input())
member=[]
for i in range(N):
    tmp=input().split(" ")
    member.append([int(tmp[0]), tmp[1], i])

member.sort(key=lambda x: (x[0], x[2]))

for mem in member:
    print(mem[0], mem[1])
