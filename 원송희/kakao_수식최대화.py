from itertools import permutations

def solution(expression):
    answer=0
    arr=list(expression)
    new_arr=[]
    temp=arr[0]
    for i in range(1, len(arr)):
        ch=arr[i]
        if i==len(arr)-1:
            temp+=ch
            new_arr.append(temp)
        if ch!='-' and ch!='+' and ch!='*':
            temp+=ch
        else:
            new_arr.append(temp)
            new_arr.append(ch)
            temp=''
    oper = ['*', '-', '+']
    permu=list(permutations(oper, 3))
    copyList=new_arr[:]
    ansList=[]
    for p in permu:
        new_arr=copyList[:]
        for i in range(3):
            idx=0
            while idx<len(new_arr):
                if p[i]==new_arr[idx]:
                    temp=new_arr[idx-1]+new_arr[idx]+new_arr[idx+1]
                    ans=eval(temp)
                    new_arr=new_arr[:idx-1]+list(str(ans).split())+new_arr[idx+2:]
                else:
                    idx+=1
        ansList.append(abs(eval(''.join(new_arr))))
    else:
        answer = max(ansList)
    return answer
