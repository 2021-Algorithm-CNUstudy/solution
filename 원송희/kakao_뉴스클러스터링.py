def solution(str1, str2):
    s1=str1.lower()
    s2=str2.lower()
    dic1={}
    dic2={}
    for i in range(len(s1)-1):
        if s1[i].isalpha() and s1[i+1].isalpha():
            temp=s1[i]+s1[i+1]
            dic1[temp]=dic1.get(temp, 0)+1
    for i in range(len(s2)-1):
        if s2[i].isalpha() and s2[i+1].isalpha():
            temp=s2[i]+s2[i+1]
            dic2[temp]=dic2.get(temp, 0)+1
    gyo=0
    hap=0
    for i in dic1:
        if i in dic2:
            gyo+=min(dic1[i], dic2[i])
    for i in dic1:
        if i in dic2:
            hap+=max(dic1[i], dic2[i])
        else:
            hap+=dic1[i]
    for i in dic2:
        if i in dic1:
            continue
        else:
            hap+=dic2[i]
    if gyo==0 and hap==0:
        return 65536
    answer=int(gyo/hap*65536)
    return answer
