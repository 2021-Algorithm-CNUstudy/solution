temp=input().split(" ")
num1=temp[0]
num2=temp[1]
num1=int(num1[::-1])
num2=int(num2[::-1])
sum=str(num1+num2)
print(int(sum[::-1])) #맨 앞이 0일 수 있으니까
