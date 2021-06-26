while(1):
    N=int(input())
    if N==0:
        break
    word=[]
    low_word=[]
    for i in range(N):
        w=input()
        word.append(w)
        low_word.append(w.lower())
    low_word.sort()
    for item in word:
        if item.lower()==low_word[0]:
            print(item)
            break
