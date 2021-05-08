def solution(n, t, m, timetable):
    answer = ''
    crew_timetable=[]
    for time in timetable:
        temp=time.split(":")
        crew_timetable.append(int(temp[0])*60+int(temp[1])) #00:00부터니까 그냥 int로
        #예를 들어 8:00면 480으로, 8:03이면 483으로 표현
    crew_timetable.sort() #온 순서대로 정렬(차례대로 태우게)
    bus_timetable=[] #버스 시간표
    for i in range(n):
        bus_timetable.append([540+(t*i), 0, -1]) #버스 시간도 8:00면 480으로
        #[버스시간, 탑승객, 마지막 승객 탑승시간],
        # 아무도 안 탄 버스의 마지막 승객 탑승 시간 = -1
    idx_c=0 #크루 index
    idx_b=0 #버스 index
    while idx_c<len(crew_timetable): #모든 승객이 탈 때까지
        crew=crew_timetable[idx_c]
        if idx_b==len(bus_timetable): #버스 끊겼으면
            break
        if crew<=bus_timetable[idx_b][0] and bus_timetable[idx_b][1]<m:
            #크루가 온 시간이 버스보다 이르거나 같고, 만원이 아니면
            bus_timetable[idx_b]=[bus_timetable[idx_b][0], bus_timetable[idx_b][1]+1, crew]
            #버스 시간 그대로, 탑승객 + 1, 마지막 승객 탑승시간 갱신
            idx_c+=1
        else: #꽉 찼으면 다음 버스로!
            idx_b+=1

    last_idx=len(bus_timetable)-1
    can_ride=bus_timetable[last_idx][0] #탈 수 있는 마지막 시간일 거 같아!
    if bus_timetable[last_idx][2]!=-1: #근데 누가 타있는 버스다! (못 탈 수도..?)
        if bus_timetable[last_idx][1]==m: #만원 버스네.. 1분 일찍 오자!
            can_ride=bus_timetable[last_idx][2]-1 #1분 일찍 오면 탈 수 있다

    if len(str(can_ride//60))==1: #아래부턴 시간 이쁘게 출력하기
        answer+="0"
        answer+=str(can_ride//60)
    else:
        answer+=str(can_ride//60)
    answer+=":"
    if len(str(can_ride%60))==1:
        answer+="0"
        answer+=str(can_ride%60)
    else:
        answer+=str(can_ride%60)
    return answer
