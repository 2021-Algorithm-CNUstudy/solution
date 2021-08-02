import sys
temp=sys.stdin.readline().split(" ")
a=temp[0]
b=int(temp[1])
after_dot_length=len(a[a.index(".")+1:])
temp=a.replace(".", "")
a=int(temp)
after_dot_length=after_dot_length*b
answer=str(a**b)
dot_idx=len(answer)-after_dot_length
if dot_idx>=0:
    print(answer[:dot_idx], end="")
    print(".", end="")
    print(answer[dot_idx:], end="")
else:
    print("0.", end="")
    print("0"*((-1)*dot_idx), end="")
    print(answer, end="")
