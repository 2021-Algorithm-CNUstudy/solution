import sys

def makeWildCard1(arr):
    toReturn=[]
    for i in range (len(arr)):
        for j in range(1, len(arr[i])+1):
            s_list=list(arr[i])
            for k in range(0, j, 1):
                s_list[k]="?"
            toReturn.append("".join(s_list))
    return toReturn

def makeWildCard2(arr):
    toReturn=[]
    for i in range(len(arr)):
        for j in range(len(arr[i])-1, -1, -1):
            s_list=list(arr[i])
            for k in range(len(s_list)-1, j-1, -1):
                s_list[k]="?"
            toReturn.append("".join(s_list))
    return toReturn

def check(q, w1, w2):
    c_list=[]
    for i in range(len(q)):
        cnt=0
        lyrics=q[i]
        if lyrics[0]=="?":
            for j in range(len(w1)):
                if lyrics==w1[j]:
                    cnt+=1
        else:
            for j in range(len(w2)):
                if lyrics==w2[j]:
                    cnt+=1
        c_list.append(cnt)
    return c_list

def solution(words, queries):
    wildcard1=makeWildCard1(words)
    wildcard2=makeWildCard2(words)
    return check(queries, wildcard1, wildcard2)
