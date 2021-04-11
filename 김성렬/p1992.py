def check(p):
    temp = p[0][0]
    for i in range(len(p)):
        for j in range(len(p)):
            if p[i][j] != temp:
                return False
    return True


def divide(p):
    n = int(len(p) / 2)
    return [i[:n] for i in p[:n]], [i[n:] for i in p[:n]], [i[:n] for i in p[n:]], [i[n:] for i in p[n:]]

def do(p):
    if check(p):
        print(p[0][0], end='')
    else:
        print('(', end='')
        for i in divide(p):
            do(i)
        print(')', end='')

m = []
for _ in range(int(input())):
    m.append(input())

do(m)