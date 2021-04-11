from sys import stdin

temp = stdin.readline().split(' ')
n = int(temp[0])
m = int(temp[1])
noListen = []
noSee = []
for i in range(n):
    noListen.append(stdin.readline())

for i in range(m):
    noSee.append(stdin.readline())

noListenAndNoSee = list(set(noListen).intersection(noSee))
noListenAndNoSee.sort()
print(len(noListenAndNoSee))
for name in noListenAndNoSee:
    print(name, end='')
