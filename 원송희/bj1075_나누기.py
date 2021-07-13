import sys
N=int(sys.stdin.readline())
F=int(sys.stdin.readline())
two_digit=[]
for i in range(100):
    temp=str(i)
    if len(temp)==2:
        two_digit.append(temp)
    else:
        temp="0"+temp
        two_digit.append(temp)

for n in two_digit:
    temp = str(N)[0:-2]
    temp+=n
    if int(temp)%F==0:
        print(temp[-2:])
        break
