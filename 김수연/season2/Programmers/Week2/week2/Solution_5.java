package week2;

import java.util.Arrays;

class Solution_5 {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        for (int i = 0; i < size; ++i) {
            int a = commands[i][0] - 1;
            int b = commands[i][1];
            
            int[] temp = new int[b - a];
            for (int j = 0; j < b - a; ++j)
                temp[j] = array[a + j];
            
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}