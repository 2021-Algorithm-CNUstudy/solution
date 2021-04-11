import sys

mone = 0
zero = 0
one = 0


def check(p):
    for i in p:
        for j in i:
            if j != p[0][0]:
                return False, 0
    return True, p[0][0]


def split(p):
    t = int(len(p) / 3)
    return [[i[:t] for i in p[:t]], \
            [i[t:t * 2] for i in p[:t]], \
            [i[t * 2:] for i in p[:t]], \
            [i[:t] for i in p[t:t * 2]], \
            [i[t:t * 2] for i in p[t:t * 2]], \
            [i[t * 2:] for i in p[t:t * 2]], \
            [i[:t] for i in p[t * 2:]], \
            [i[t:t * 2] for i in p[t * 2:]], \
            [i[t * 2:] for i in p[t * 2:]]]


def do(p):
    global one, zero, mone
    a, n = check(p)
    if a:
        if n == '1':
            one += 1
        elif n == '0':
            zero += 1
        else:
            mone += 1
    else:
        for i in split(p):
            do(i)


paper = []
for _ in range(int(sys.stdin.readline())):
    paper.append(sys.stdin.readline().split())

do(paper)
print(mone, zero, one)
