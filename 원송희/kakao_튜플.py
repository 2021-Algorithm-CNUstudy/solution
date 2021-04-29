def solution(s):
    answer=[]
    s=s[1:-1]
    s=s.replace("},{", "}, {")
    setArr=s.split(", ")
    setArr.sort(key=len)
    for set in setArr:
        set=set[1:-1]
        num=set.split(",")
        for n in num:
            n=int(n)
            if n in answer:
                continue
            else:
                answer.append(n)
    return answer
