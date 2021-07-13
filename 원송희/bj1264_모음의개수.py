import sys
while(1):
    sentence=sys.stdin.readline().rsplit()
    cnt=0
    if sentence==["#"]:
        break
    sentence="".join(sentence)
    for ch in sentence:
        if ch in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
            cnt+=1
    print(cnt)
