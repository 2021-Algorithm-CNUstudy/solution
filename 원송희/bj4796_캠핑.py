import sys
idx=1
while(1):
    temp=sys.stdin.readline().split(" ")
    L_P_V=list(map(int, temp))
    if L_P_V==[0, 0, 0]:
        break
    L=L_P_V[0]
    P=L_P_V[1]
    V=L_P_V[2]
    day=0
    day+=V//P*L
    V-=V//P*P
    if V>L:
        day+=L
    else:
        day+=V
    print("Case", idx, end="")
    print(":", day)
    idx+=1
