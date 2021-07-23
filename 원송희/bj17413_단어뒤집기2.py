import sys
sentence=sys.stdin.readline().rstrip() # 뒤에 \n빼고 string형으로 저장
temp="" # 뒤집을 문자열 저장할 공간
tag_flag=False # <>사이의 문자열인지 아닌지 체크하기 위한 flag
for character in sentence: # 한 글자씩 체크
    if character=="<":
        print(temp[::-1], end="") # temp에 있는 문자열 뒤집어서 출력
        temp="" # 초기화
        print(character, end="") # < 출력
        tag_flag=True # 앞으로 나오는 문자열은 안 뒤집기 위해 flag를 True로 설정
    elif character==">":
        print(character, end="") # > 출력
        tag_flag=False # 이제 나오는 문자열은 뒤집기 위해 flag를 False로 설정
    elif character==" ": # 공백이면
        print(temp[::-1], end="") # 지금까지 나왔었던 문자열 뒤집어서 출력하고
        print(character, end="") # 공백 출력하고
        temp="" # temp 초기화
    elif tag_flag==True:
        print(character, end="") # <> 사이 문자열이면 그냥 출력
    elif tag_flag==False:
        temp+=character # <> 사이 문자열 아니면 temp에 한 글자씩 추가하면서 저장
print(temp[::-1], end="") # 마지막에 temp에 저장되어있는 문자열 뒤집어서 출력
# 마지막 문자열이 <>안에 있으면 temp에 아무것도 저장이 안 되어 있어서 그냥 출력해도 괜찮음
