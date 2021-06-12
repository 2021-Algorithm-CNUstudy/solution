temp=input().split(" ")
N=int(temp[0])
M=int(temp[1])
K=int(temp[2])

team=0
while(1):
    if N<2 or M<1:
        break
    N-=2
    M-=1
    team+=1
rest=N+M
if rest>=K:
    print(team)
else:
    while(1):
        if rest>=K:
            break
        team-=1
        rest+=3
    print(team)
