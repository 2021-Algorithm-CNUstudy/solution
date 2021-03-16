from itertools import combinations

n, m = map(int, input().split())

house, chicken = [], []
for i in range(n):
    for j, place in enumerate(list(map(int, input().split()))):
        if place == 1:
            house.append([i+1, j+1])
        elif place == 2:
            chicken.append([i+1, j+1])

dis_list = []
for com in combinations(chicken, m):
    c_dis = 0
    for h in house:
        can_dis = [abs(h[0]-c[0])+abs(h[1]-c[1]) for c in com]
        c_dis += min(can_dis)
    dis_list.append(c_dis)
print(min(dis_list))

