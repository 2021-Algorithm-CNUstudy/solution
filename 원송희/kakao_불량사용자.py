from itertools import permutations
import re
def solution(user_id, banned_id):
    answer = 0
    s=[]
    permu=list(permutations(user_id, len(banned_id)))
    for p in permu:
        for i in range (len(banned_id)):
            banned_id[i]=banned_id[i].replace("*", ".")
            regular=re.compile(banned_id[i])
            match=regular.match(p[i])
            if match and len(p[i])==len(banned_id[i]):
                if i==len(banned_id)-1:
                    t = []
                    for j in range(len(banned_id)):
                        t.append(p[j])
                    t.sort()
                    t=tuple(t)
                    s.append(t)
            else:
                break
    s=set(s)
    answer=len(s)
    return answer
