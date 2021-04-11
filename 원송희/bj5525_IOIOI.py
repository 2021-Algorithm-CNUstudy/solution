import sys

n=int(sys.stdin.readline())
m=int(sys.stdin.readline())
ioi=sys.stdin.readline()
answer=0
idx=1
pattern=0
while idx < m-1:
    if ioi[idx-1]=='I' and ioi[idx]=='O' and ioi[idx+1]=='I':
        pattern+=1
        if pattern==n:
            pattern-=1
            answer+=1
        idx+=2 #I를 건너뛰기 위함
    else:
        pattern=0
        idx+=1
print(answer)
