from collections import defaultdict
def solution(n, results):
    answer = 0
    winner_graph=defaultdict(list)
    loser_graph=defaultdict(list)
    for result in results:
        winner=result[0]
        loser=result[1]
        winner_graph[loser].append(winner)
        loser_graph[winner].append(loser)
    for i in range(1, n+1):
        for winner in winner_graph[i]:
            loser_graph[winner]+=loser_graph[i] # 모순이 없으니까 가능한 식
            loser_graph[winner]=list(set(loser_graph[winner])) # 중복 제거
        for loser in loser_graph[i]:
            winner_graph[loser]+=winner_graph[i] # 모순이 없으니까 가능한 식
            winner_graph[loser]=list(set(winner_graph[loser])) # 중복 제거
    for i in range(1, n+1):
        if len(winner_graph[i])+len(loser_graph[i])+1==n:
            answer+=1
    return answer
