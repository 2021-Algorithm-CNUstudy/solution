def solution(numbers, hand):
    answer=''
    left_loc=10
    right_loc=11
    dictionary = {(1, 2): 1, (1, 5): 2, (1, 8): 3, (1, 0): 4,
                  (4, 2): 2, (4, 5): 1, (4, 8): 2, (4, 0): 3,
                  (7, 2): 3, (7, 5): 2, (7, 8): 1, (7, 0): 2,
                  (3, 2): 1, (3, 5): 2, (3, 8): 3, (3, 0): 4,
                  (6, 2): 2, (6, 5): 1, (6, 8): 2, (6, 0): 3,
                  (9, 2): 3, (9, 5): 2, (9, 8): 1, (9, 0): 2,
                  (2, 2): 0, (2, 5): 1, (2, 8): 2, (2, 0): 3,
                  (5, 2): 1, (5, 5): 0, (5, 8): 1, (5, 0): 2,
                  (8, 2): 2, (8, 5): 1, (8, 8): 0, (8, 0): 1,
                  (0, 2): 3, (0, 5): 2, (0, 8): 1, (0, 0): 0,
                  (10, 2): 4, (10, 5): 3, (10, 8): 2, (10, 0): 1,
                  (11, 2): 4, (11, 5): 3, (11, 8): 2, (11, 0): 1
                 }
    for num in numbers:
        if num==1 or num==4 or num==7:
            left_loc = num
            answer+='L'
        elif num==3 or num==6 or num==9:
            right_loc = num
            answer+='R'
        else:
            left_dis=dictionary[(left_loc, num)]
            right_dis=dictionary[(right_loc, num)]
            if left_dis==right_dis:
                if hand=="left":
                    left_loc=num
                    answer+='L'
                else:
                    right_loc=num
                    answer+='R'
            elif left_dis>right_dis:
                right_loc=num
                answer+='R'
            else:
                left_loc=num
                answer+='L'
    return answer
