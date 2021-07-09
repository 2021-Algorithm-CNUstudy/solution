import sys
while(1):
    temp=sys.stdin.readline().split(" ")
    if temp[0]=="#":
        break
    name=temp[0]
    age=int(temp[1])
    weight=int(temp[2])
    if age>17 or weight>=80:
        answer=name+" "+"Senior"
        print(answer)
    else:
        answer=name+" "+"Junior"
        print(answer)
