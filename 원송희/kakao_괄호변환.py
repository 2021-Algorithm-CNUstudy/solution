import sys

s = sys.stdin.readline().rstrip()


# 균형잡힌 괄호 슬라이싱
def slice(s):
    check = 0
    for i in range(len(s)):
        if s[i] == '(':
            check += 1
        elif s[i] == ')':
            check -= 1
        if check == 0:
            return i  # 슬라이싱 기준 인덱스 리턴


def check(s):
    queue = []
    for i in range(len(s)):
        if s[i] == '(':
            queue.append(s[i])
        else:
            try:
                queue.pop()
            except:
                return False
                # 예외 날리기
    if len(queue) == 0:
        return True
    return False


def solution(s):
    answer = ''
    if s == "":
        return s

    if check(s):  # 이미 올바른 문자열이면 리턴하기
        return s

    idx = slice(s) + 1  # 슬라이싱 기준 인덱스
    u = s[0:idx]
    v = s[idx:len(s)]
    if check(u):
        answer += u + solution(v)
        return answer
    else:
        temp = '('
        temp += solution(v)
        v = temp  # 괄호 붙이기
        v += ')'
        u = u[1:len(u) - 1]  # 맨 앞, 맨 뒤 제거
        u_list=list(u)
        for i in range(len(u_list)):
            if u_list[i] == "(":
                u_list[i] = ")"
            elif u_list[i] == ")":
                u_list[i] = "("
        u="".join(u_list)
        answer = v + u
        return answer
