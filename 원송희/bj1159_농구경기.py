import sys
N=int(sys.stdin.readline())
letter=[]
for i in range(N):
    temp=sys.stdin.readline()
    letter.append(temp[0])
letter_set=set(letter)
answer=[]
for l in letter_set:
    if letter.count(l)>=5:
        answer.append(l)
if answer==[]:
    print("PREDAJA")
else:
    answer.sort()
    for a in answer:
        print(a, end="")
