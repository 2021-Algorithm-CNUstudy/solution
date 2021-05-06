def solution(cacheSize, cities):
    answer = 0
    if cacheSize==0:
        return len(cities)*5
    cache=[]
    for c in cities:
        c=c.lower()
        if c not in cache:
            if len(cache)==cacheSize:
                cache.pop()
            answer+=5
        else:
            idx=cache.index(c)
            del cache[idx]
            answer+=1
        cache.insert(0, c)
    return answer
