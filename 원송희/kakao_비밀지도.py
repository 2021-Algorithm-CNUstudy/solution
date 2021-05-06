def solution(n, arr1, arr2):
    answer = []
    board1=[]
    board2=[]
    for i in range(n):
        num1=arr1[i]
        num2=arr2[i]
        s1=""
        s2=""
        for j in range(n-1, -1, -1):
            if num1>=2**j:
                s1+="#"
                num1-=2**j
            else:
                s1+=" "
        board1.append(s1)
        for j in range(n-1, -1, -1):
            if num2>=2**j:
                s2+="#"
                num2-=2**j
            else:
                s2+=" "
        board2.append(s2)
    for i in range(n):
        temp1=board1[i]
        temp2=board2[i]
        ans_s=""
        for j in range(n):
            if temp1[j]=="#" or temp2[j]=="#":
               ans_s+="#"
            else:
                ans_s+=" "
        answer.append(ans_s)
    return answer
