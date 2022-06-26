def solution(triangle):
    for i in range(len(triangle)):
        temp = [0 for _ in range(len(triangle)-i)]
        triangle[i]+=temp
    dp = triangle[:]
    for i in range(1, len(dp)):
        for j in range(len(dp)):
            dp[i][j] = max(dp[i-1][j]+triangle[i][j], dp[i-1][j-1]+triangle[i][j])
    answer = max(dp[-1])
    return answer
