from sys import stdin

T=int(stdin.readline())
s=set()

for i in range(T):
    input=stdin.readline().strip().split()
    if len(input)==1: #all 또는 empty
        if input[0]=='all':
            s=set([i for i in range(1, 21)])
        elif input[0]=='empty':
            s=set()
        continue
    else:
        op=input[0]
        num=int(input[1])
        if op=='add':
            s.add(num)
        elif op=='remove':
            s.discard(num)
        elif op=='check':
            if num in s:
                print(1)
            else:
                print(0)
        elif op=='toggle':
            if num in s:
                s.discard(num)
            else:
                s.add(num)
