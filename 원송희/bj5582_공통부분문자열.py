import sys
word1="_"+sys.stdin.readline().rstrip() # 인덱스 에러를 방지하기 위한 _ 추가
word2="_"+sys.stdin.readline().rstrip() # _ 의 dp에는 0으로 채워넣기
dp=[[0]*len(word2) for _ in range(len(word1))]
answer=0
for i in range(1, len(word1)): # _ 빼고 for문 돌리기
    for j in range(1, len(word2)):
        if word1[i]==word2[j]:
            dp[i][j]=dp[i-1][j-1]+1
            if dp[i][j]>answer:
                answer=dp[i][j]
print(answer)
