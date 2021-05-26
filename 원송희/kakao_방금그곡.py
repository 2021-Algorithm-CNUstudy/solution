def makeMelody(m):
    m = list(m)
    melody = []
    for i in range(len(m) - 1):
        if m[i] == "#":
            continue
        if m[i + 1] == "#":
            melody.append(m[i].lower() + "#") # #음들은 소문자처리해서 문자열비교
        else:
            melody.append(m[i])
    if m[len(m)-1]!="#":
        melody.append(m[len(m)-1])
    return melody

def solution(m, musicinfos):
    melody=makeMelody(m)
    melody="".join(melody)
    idx=0
    for info in musicinfos: # Data Transformation
        # [0]: start, [1]: end, [2]: title, [3]: melody,
        # [4]: played time, [5]: played melody
        info=info.split(",")
        temp=info[0].split(":")
        time=int(temp[0])*60+int(temp[1])
        info[0]=time
        temp=info[1].split(":")
        time=int(temp[0])*60+int(temp[1])
        info[1]=time
        temp=makeMelody(info[3]) # make melody (str -> arr)
        info[3]=temp
        played_time=info[1]-info[0] # to connect song
        info.append(played_time)
        song_length=len(info[3]) # length of the song
        played_melody=info[3]*(played_time//song_length) # in reality ..
        for i in range(played_time%song_length):
            played_melody.append(info[3][i]) # the song played like this ..
        played_melody="".join(played_melody) # arr -> str (to compare with m)
        info.append(played_melody)
        musicinfos[idx]=info
        idx+=1
    candidates=[]
    for info in musicinfos:
        print(info)
        if melody in info[5]:
            candidates.append(info)
    if len(candidates)==0:
        return "(None)"
    elif len(candidates)==1:
        return candidates[0][2]
    else:
        max=candidates[0][4]
        idx=0
        for i in range(1, len(candidates)):
            if max>candidates[i][4]:
                continue
            elif max<candidates[i][4]:
                idx=i
                max=candidates[i][4]
    return candidates[idx][2]
