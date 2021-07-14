import sys
temp=sys.stdin.readline().rsplit()
score=list(map(int, temp))
max_score=[100, 100, 200, 200, 300, 300, 400, 400, 500]
sum_score=0
isHacker=False
for i in range(9):
    sum_score+=score[i]
    if score[i]>max_score[i]:
        isHacker=True
        print("hacker")
        break
    elif sum_score>=100:
        print("draw")
        break
if sum_score<100 and isHacker==False:
    print("none")
