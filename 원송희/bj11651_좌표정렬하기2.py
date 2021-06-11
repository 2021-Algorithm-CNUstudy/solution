N=int(input())
coordinate=[]
for i in range(N):
    temp=input().split(" ")
    x=int(temp[0])
    y=int(temp[1])
    coordinate.append([x, y])

coordinate.sort(key=lambda x: (x[1], x[0]))

for coor in coordinate:
    print(coor[0], coor[1])
