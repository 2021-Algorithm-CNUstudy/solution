package problem;


import java.util.Arrays;

class Solution_2 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int answer = n - lost.length;
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - reserve[j] == 0) {
                    answer++;
                    lost[i] = -200;
                    reserve[j] = -100;
                    break;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - reserve[j] == 1 || lost[i] - reserve[j] == -1) {
                    answer++;
                    reserve[j] = -100;
                    break;
                }
            }
        }
        
        return answer;
    }
}
