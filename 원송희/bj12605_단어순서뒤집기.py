import sys
N=int(sys.stdin.readline())
for i in range(N):
    sentence=sys.stdin.readline().rstrip()
    sentence=sentence.split(" ")
    print("Case #", end="")
    print(i+1, end="")
    print(": ", end="")
    sentence.reverse()
    for s in sentence:
        print(s, end=" ")
    print()
