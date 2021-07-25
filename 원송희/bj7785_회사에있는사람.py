import sys
N=int(sys.stdin.readline())
log=[]
for i in range(N):
    temp=sys.stdin.readline().rstrip()
    temp=temp.split(" ")
    name=temp[0]
    situation=temp[1]
    if situation=="enter":
        log.append(name)
    elif situation=="leave":
        log.remove(name)
log.sort(reverse=True)
for person in log:
    print(person)
