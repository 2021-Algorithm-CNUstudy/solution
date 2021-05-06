def solution(dartResult):
    l=list(dartResult) #한 글자씩 리스트 처리
    real_list=[] #10점을 처리하기 위함
    for i in range(len(l)):
        if l[i]=="1" and l[i+1]=="0":
            real_list.append("10")
        elif l[i]=="0" and l[i-1]=="1":
            continue
        else:
            real_list.append(l[i])
    calc=[int(real_list[0]), 0, 0]
    idx=0
    for i in range(1, len(real_list)):
        if real_list[i].isdigit():
            idx+=1
            calc[idx]+=int(real_list[i])
            continue
        elif real_list[i]=="S":
            calc[idx]=calc[idx]**1
        elif real_list[i]=="D":
            calc[idx]=calc[idx]**2
        elif real_list[i]=="T":
            calc[idx]=calc[idx]**3
        elif real_list[i]=="*":
            if idx==0:
                calc[idx]*=2
            else:
                calc[idx]*=2
                calc[idx-1]*=2
        elif real_list[i]=="#":
            calc[idx]*=-1
    answer=sum(calc)
    return answer
