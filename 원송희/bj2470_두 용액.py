import sys

N = int(sys.stdin.readline())
liquid = list(map(int, sys.stdin.readline().split(" ")))

liquid.sort()

left=0
right=len(liquid)-1
total=2e9+1
left_answer=0
right_answer=0

while left<right:
    if abs(liquid[left]+liquid[right])<total:
        total=abs(liquid[left]+liquid[right])
        left_answer=left
        right_answer=right
    if liquid[left]+liquid[right]<0:
        left+=1
    else:
        right-=1

print(liquid[left_answer], liquid[right_answer])
