import sys
temp=sys.stdin.readline().rsplit()
temp=list(map(int, temp))
number=1
while(1):
    cnt=0
    for num in temp:
        if number%num==0 and number>=num:
            cnt+=1
    if cnt>=3:
        print(number)
        break
    number+=1

