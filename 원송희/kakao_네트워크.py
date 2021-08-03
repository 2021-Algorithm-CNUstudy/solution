def dfs(n, computers, visited, i):
    visited[i]=True # 방문 기록
    for j in range(n): # 다른 column들과 비교하는데
        if i!=j and computers[i][j]==1 and visited[j]==False:
            # 자기 자신과 다르고, 아직 방문 안했고, 이어져 있는 것에 대해서만
            # dfs 실행
            dfs(n, computers, visited, j)

def solution(n, computers):
    answer=0
    visited=[False for _ in range(n)]
    for i in range(n):
        if visited[i]==False: # 방문 안 한 row이면
            answer+=1 # 연결된 것들은 dfs안에서 다 실행되어 다 visited=True 처리될 것임
            dfs(n, computers, visited, i) # dfs 실행
    return answer
