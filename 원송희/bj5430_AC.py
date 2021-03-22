from sys import stdin

T=int(stdin.readline())
for _ in range(T):
    func=stdin.readline()
    num=stdin.readline().rstrip()
    arr=stdin.readline().rstrip()[1:-1].split(',')
    if int(num) < func.count('D'):
        print('error')
        continue
    rev=1
    func=func.replace('RR', '') #시간초과의 원인이 아닐까?!
    for i in range(0, len(func), 1):
        if func[i]=='R':
            rev*=-1
        elif func[i]=='D':
            if rev==1:
                arr.pop(0)
            elif rev==-1:
                arr.pop(-1)
    if len(arr)==0:
        print('[]')
        continue
    if rev==1:
        print('['+','.join(arr)+']')
    elif rev==-1:
        arr=arr[::-1]
        print('['+','.join(arr)+']')
