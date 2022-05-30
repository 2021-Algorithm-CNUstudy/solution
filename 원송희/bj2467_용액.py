import sys

N = int(sys.stdin.readline())
drink = list(map(int, sys.stdin.readline().split(" ")))
left = 0 # 투포인터
right = N-1
answer_left = 0
answer_right = 0

answer = 2000000001 # 제한에 맞게 설정

while left<right:
    two = drink[left]+drink[right]
    if abs(two)<answer:
        answer=abs(two)
        answer_left=left
        answer_right=right
    if two < 0:
        left+=1
    elif two > 0:
        right-=1
    else:
        break
print(drink[answer_left], drink[answer_right])
