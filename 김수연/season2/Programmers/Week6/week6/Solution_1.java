package week6;

// 복서 정렬하기
import java.util.*;

class Solution_1 {
    public int[] solution(int[] weights, String[] head2head) {
        int length = weights.length;
        
        // info[][0] number
        // info[][1] win rate
        // info[][2] heavy win count
        double[][] info = new double[length][3];
        for (int i = 0; i < length; ++i) {
            info[i][0] = i + 1;
            
            int totalCompetition = 0;
            int winCompetition = 0;
            int count = 0;
            for (int j = 0; j < length; ++j) {
                char win = head2head[i].charAt(j);
                if (win == 'W' || win == 'L') {
                    ++totalCompetition;
                    if (win == 'W')
                        ++winCompetition;
                }
                
                if (win == 'W' && weights[i] < weights[j])
                    ++count;
            }
            
            if (totalCompetition > 0)
                info[i][1] = (double) winCompetition / totalCompetition;
            info[i][2] = count;
        }
        
        Arrays.sort(info, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        if (weights[(int) o2[0] - 1] == weights[(int) o1[0] - 1])
                            return (int) o1[0] - (int) o2[0];
                        return weights[(int) o2[0] - 1] - weights[(int) o1[0] - 1];
                    }
                    return (int) o2[2] - (int) o1[2];
                }
                else if (o1[1] > o2[1]) return -1;
                else return 1;
            }
        });
        
        int[] answer = new int[length];
        for (int i = 0; i < length; ++i)
            answer[i] = (int) info[i][0];
        
        return answer;
    }
}