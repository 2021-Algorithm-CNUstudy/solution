def solution(record):
    answer = []
    user_info = {}
    for i in range(len(record)):
        word=record[i].split(" ")
        if record[i][0] == "E"  or record[i][0] == "C":
            user_info[word[1]] = word[2]
        elif record[i][0] == "L":
            continue
    for i in range(len(record)):
        word=record[i].split(" ")
        if record[i][0] == "E":
            temp="님이 들어왔습니다."
            temp=user_info[word[1]] + temp
            answer.append(temp)
        elif record[i][0] == "L":
            temp="님이 나갔습니다."
            temp=user_info[word[1]] + temp
            answer.append(temp)
        elif record[i][0] == "C":
            continue
    return answer
