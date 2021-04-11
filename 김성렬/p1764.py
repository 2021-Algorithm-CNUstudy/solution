n, m = map(int, input().split())
l = {}
ans = []
for _ in range(n+m):
    i = input()
    if l.get(i) is None:
        l[i] = 1
    else:
        ans.append(i)
ans.sort()
print(len(ans))
for i in ans:
    print(i)