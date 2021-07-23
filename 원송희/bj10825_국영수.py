import sys
N=int(sys.stdin.readline())
score=[]
for i in range(N):
    temp=sys.stdin.readline().split(" ")
    name=temp[0]
    korean=int(temp[1])
    english=int(temp[2])
    math=int(temp[3])
    temp=[name, korean, english, math]
    score.append(temp)
score.sort(key=lambda x:(-x[1], x[2], -x[3], x[0]))
for student in score:
    print(student[0])
