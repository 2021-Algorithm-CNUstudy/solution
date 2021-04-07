import sys

word=sys.stdin.readline().rstrip() #\n없애서 읽기
def solution(word):
    pattern=1
    min_len=1000
    if len(word)==1 or len(word)==2:
        return len(word)
    else:
        for i in range(len(word)):
            answer=""
            list=[]
            for j in range(0, len(word)//pattern+1, 1):
                if j*pattern+pattern>len(word)-1:
                    list.append(word[j*pattern:len(word)])
                else:
                    list.append(word[j*pattern:j*pattern+pattern]) #문자열 슬라이싱해서 저장
                list=' '.join(list).split() #빈 문자열 제거
            idx=0
            while(idx<len(list)):
                cnt = 1
                for n in range(idx + 1, len(list), 1):
                    if list[idx] == list[n]:
                        cnt += 1
                    else:
                        break
                if cnt != 1:
                    answer += str(cnt)
                answer += list[idx]
                idx+=cnt
            if min_len > len(answer):
                min_len = len(answer)
            pattern+=1
        return min_len
