package week5;

// 모음 사전
class Solution_1 {
    public int solution(String word) {
        int[] list = {781, 156, 31, 6, 1};
        char[] input = word.toCharArray();
        
        int answer = 0;
        for (int i = 0; i < input.length; ++i) {
            char inputA = input[i];
            
            if (inputA == 'A') {
                answer += list[i] * 0 + 1;
            } else if (inputA == 'E') {
                answer += list[i] * 1 + 1;
            } else if (inputA == 'I') {
                answer += list[i] * 2 + 1;
            } else if (inputA == 'O') {
                answer += list[i] * 3 + 1;
            } else {
                answer += list[i] * 4 + 1;
            }
        }
        
        return answer;
    }
}