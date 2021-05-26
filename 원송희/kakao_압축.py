def solution(files):
    answer = []
    idx=0
    for file in files:
        info=[]
        # [0]: head, [1]: temp_head,
        # [2]: number, [3]: temp_number,
        # [4]: tail
        for i in range(len(file)):
            if file[i].isdigit():
                info.append(file[:i]) # head
                break
        info.append(info[0].lower())
        s_idx=0
        e_idx=0
        for i in range(len(file)):
            if file[i].isdigit():
               s_idx=i
               for j in range(i, len(file)):
                   if not file[j].isdigit():
                       e_idx=j
                       break
                   if file[j].isdigit() and j==len(file)-1: # no tail file
                       e_idx=j+1
               break
        info.append(file[s_idx:e_idx]) # number
        info.append(int(info[2]))
        info.append(file[e_idx:]) # tail
        files[idx]=info
        idx+=1
    files.sort(key=lambda x:(x[1], x[3])) # compare files by using temp head and number
    for i in range (len(files)):
        del files[i][1]
        del files[i][2] # not 3 because already temp head is deleted
        file="".join(files[i])
        answer.append(file)
    return answer

print(solution(["F-5 Freedom Fighter", "B-50 Superfortress",
                "A-10 Thunderbolt II", "F-14 Tomcat"]))
