def solution(board, moves):
    answer = 0
    box=[]
    for move in moves:
        for i in range(len(board)):
            if board[i][move-1]!=0:
                picked=board[i][move-1]
                board[i][move-1]=0
                if len(box)==0:
                    box.append(picked)
                elif len(box)>0 and box[-1]!=picked:
                    box.append(picked)
                else:
                    answer+=2
                    del box[-1]
                break
    return answer
