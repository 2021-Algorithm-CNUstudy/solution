import sys
score_arr=[]
for i in range(8):
    score=int(sys.stdin.readline())
    score_arr.append([i+1, score])
score_arr.sort(key=lambda x: x[1])
sum_score=score_arr[7][1]+score_arr[6][1]+score_arr[5][1]+score_arr[4][1]+score_arr[3][1]
print(sum_score)
problem_arr=[]
problem_arr.append(score_arr[7][0])
problem_arr.append(score_arr[6][0])
problem_arr.append(score_arr[5][0])
problem_arr.append(score_arr[4][0])
problem_arr.append(score_arr[3][0])
problem_arr.sort()
for problem in problem_arr:
    print(problem, end=" ")
