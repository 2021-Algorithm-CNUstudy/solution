import sys
T=int(sys.stdin.readline())
for i in range(T):
    sound=sys.stdin.readline().rstrip()
    sound=sound.split(" ")
    sound_dic={}
    while(1):
        sentence=sys.stdin.readline().rstrip()
        if sentence!="what does the fox say?":
            sentence=sentence.split(" goes ")
            sound_dic[sentence[1]]=sentence[0]
        else:
            break
    for s in sound:
        if s not in sound_dic:
            print(s, end=" ")
    print()
