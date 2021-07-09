import sys
N=int(sys.stdin.readline())
cmd=[]
for i in range(N):
    cmd.append(str(sys.stdin.readline().rsplit())[2:-2])
answer=""
for i in range(len(cmd[0])):
    standard=cmd[0]
    flag=True
    for file in cmd:
        if standard[i]!=file[i]:
            answer+="?"
            flag=False
            break
    if flag==True:
        answer+=standard[i]
print(answer)
