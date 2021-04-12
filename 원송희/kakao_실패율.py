def solution(N, stages):
    answer = []
    fail = [[0 for col in range(N)] for row in range(3)]
    for i in range(N):
        fail[0][i] = i+1
        fail[1][i] = 0 #도달 but no clear
        fail[2][i] = 0 #도달
    for i in range(len(stages)): #fail[1] 라인, no clear
        lastStage = stages[i]
        if lastStage > N:
            continue
        else:
            fail[1][lastStage-1]+=1
    for i in range(len(stages)): #fail[2] 라인, reached
        lastStage = stages[i]
        if lastStage > N:
            for j in range(N):
                fail[2][j] += 1
        else:
            for j in range(0, lastStage, 1):
                fail[2][j] += 1
    failRate = []
    for i in range(N):
        if fail[2][i] == 0:
            failRate.append((i+1, 0.0))
        else:
            failRate.append((i+1, fail[1][i] / fail[2][i]))
    failRate.sort(key = lambda x:-x[1])
    for i in range(N):
        answer.append(failRate[i][0])
    return answer
