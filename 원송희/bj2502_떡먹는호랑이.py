import sys
temp=sys.stdin.readline().rsplit()
D=int(temp[0])
K=int(temp[1])
rice_cake=[]
rice_cake.append((1, 0))
rice_cake.append((0, 1))
for i in range(2, 31):
    rice_cake.append((rice_cake[i-2][0]+rice_cake[i-1][0], rice_cake[i-2][1]+rice_cake[i-1][1]))
today=rice_cake[D-1]
for i in range(1, K//today[0], 1):
    if (K-(today[0]*i))%today[1]==0:
        print(i)
        print((K-(today[0]*i))//today[1])
        break
