import sys
N=int(sys.stdin.readline())
number=1
while number*(number+1)/2<=N:
    number+=1
number-=1
print(number)
