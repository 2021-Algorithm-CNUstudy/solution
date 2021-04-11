def canWork(t):  # 가능한 작업인지 체크
    for x, y, a in t:  # 튜플로 저장된 형태 이용
        if a == 0:  # 기둥
            if y == 0 or (x, y - 1, 0) in t or (x - 1, y, 1) in t or (x, y, 1) in t:
                continue
            else:
                return False  # 못 세움
        elif a == 1:  # 보
            if (x, y - 1, 0) in t or (x + 1, y - 1, 0) in t or ((x - 1, y, 1) in t and (x + 1, y, 1) in t):
                continue
            else:
                return False  # 못 세움
    return True


def solution(n, build_frame):
    toReturn = []
    for arr in build_frame:
        t = (x, y, a)  # 튜플 형태로 저장하겠음, 그러나 b는 작업 가능 여부에 영향x이므로 빼고, 그렇지 않으면 canWork(t)의 if문만 복잡해짐
        if b == 0:  # 삭제
            toReturn.remove(t)
            if canWork(toReturn) == False:  # 삭제할 수 없으면
                toReturn.append(t)
            else:
                continue
        elif b == 1:  # 추가
            toReturn.append(t)
            if canWork(toReturn) == False:  # 세울 수 없으면
                toReturn.remove(t)
            else:
                continue
    answer = map(list, toReturn) # 리스트 형태로 변경해서 맵핑
    answer = sorted(answer, key=lambda order: (order[0], order[1], order[2])) # 정렬
    return answer
