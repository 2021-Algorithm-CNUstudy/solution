import sys
N=int(sys.stdin.readline())
medalist=[]
for i in range(N):
    medalist.append(list(map(int, sys.stdin.readline().rsplit())))
medalist.sort(key=lambda x:-x[2])

country=[]
print(medalist[0][0], medalist[0][1])
country.append(medalist[0][0])
print(medalist[1][0], medalist[1][1])
country.append(medalist[1][0])
for i in range(2, len(medalist)):
    if medalist[i][0] in country and country.count(medalist[i][0])==2:
        continue
    else:
        print(medalist[i][0], medalist[i][1])
        break
