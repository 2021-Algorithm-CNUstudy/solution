import sys

testcase=int(sys.stdin.readline())
for _ in range(testcase):
    n = int(sys.stdin.readline())
    if n==0: #이거 때문에 계속 틀렸었음 ㅡㅡ
        print(0)
    else:
        list=[]
        for i in range(n):
            kinds=sys.stdin.readline().split(" ")[1]
            list.append(kinds)
        s=set(list)
        list2=[]
        for i in range(len(s)):
            list2.append(list.count(tuple(s)[i]))
        if len(list2)==1:
            print(list2[0])
        else:
            day=list2[0]+1
            for i in range(1, len(list2), 1):
                day*=list2[i]+1
            print(day-1)
