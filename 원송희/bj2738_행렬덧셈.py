temp=input().split(" ")
n=int(temp[0])
m=int(temp[1])
matrix1=[]
matrix2=[]
for i in range(n):
    matrix1.append(input().split(" "))
for i in range(n):
    matrix2.append(input().split(" "))
sum_matrix=[]
for i in range(n):
    sum_list=[]
    for j in range(m):
        num1=int(matrix1[i][j])
        num2=int(matrix2[i][j])
        num3=num1+num2
        sum_list.append(num3)
    sum_matrix.append(sum_list)
for i in range(n):
    for j in range(m):
        print(sum_matrix[i][j], end=" ")
    print()
