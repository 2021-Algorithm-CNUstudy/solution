import sys

testcase=int(sys.stdin.readline())
beHappy=20*50 #50m당 맥주 1병씩 가능한지 체크하기 위함
dis_max=(32767+32768)*2+1#문제 조건 상 최대 거리

for _ in range(testcase):
    n=int(sys.stdin.readline())
    map=[]
    distance=[[dis_max for i in range(n+2)] for j in range(n+2)]
    for i in range(n+2):
        temp=sys.stdin.readline().split(" ")
        X=int(temp[0])
        Y=int(temp[1])
        map.append((X, Y)) #tuple을 활용하여 x,y 좌표를 배열에 넣음
    for i in range(n+2):
        for j in range(n+2):
            if i==j:
                continue
            if abs(map[i][0]-map[j][0]) + abs(map[i][1]-map[j][1]) <= beHappy:
                distance[i][j]=distance[j][i]=1
    for i in range(n+2):
        for j in range(n+2):
            for k in range(n+2):
                distance[j][k]=min(distance[j][k], distance[j][i]+distance[i][k])
    print(distance)
    if distance[0][n+1] < dis_max: #도달
        print("happy")
    else:
        print("sad")
