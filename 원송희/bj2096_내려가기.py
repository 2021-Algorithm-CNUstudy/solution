import sys
N=int(sys.stdin.readline())
min_table=[[0]*3 for _ in range(2)]
max_table=[[0]*3 for _ in range(2)]
for i in range(N):
    table=list(map(int, sys.stdin.readline().split(" ")))
    min_table[1][0]=min(min_table[0][0], min_table[0][1])+table[0]
    max_table[1][0]=max(max_table[0][0], max_table[0][1])+table[0]
    min_table[1][1]=min(min_table[0][0], min_table[0][1], min_table[0][2])+table[1]
    max_table[1][1]=max(max_table[0][0], max_table[0][1], max_table[0][2])+table[1]
    min_table[1][2]=min(min_table[0][1], min_table[0][2])+table[2]
    max_table[1][2]=max(max_table[0][1], max_table[0][2])+table[2]
    for j in range(3):
        min_table[0][j]=min_table[1][j]
        max_table[0][j]=max_table[1][j]
print(max(max_table[1]), min(min_table[1]))
