import java.util.*;

// 크레인 인형뽑기 게임
class Solution_3 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < moves.length; ++i) {
            int popIndex = moves[i] - 1;
            
            for (int row = 0; row < board.length; ++row) {
                int popElement = board[row][popIndex];
                
                if (popElement != 0) {
                    board[row][popIndex] = 0;
                    
                    if (stack.size() != 0) {
                        if (stack.peek() == popElement) {
                            stack.pop();
                            answer += 2;
                        } else stack.push(popElement);
                    } else stack.push(popElement);
                    break;
                }
            }
        }
        return answer;
    }
}