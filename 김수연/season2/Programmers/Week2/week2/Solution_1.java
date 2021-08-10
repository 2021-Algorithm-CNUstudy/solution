package week2;

// 상호 평가
import java.util.*;

class Solution_1 {
    public String solution(int[][] scores) {
        int n = scores.length;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; ++i) {
            int[] list = new int[n];
            for (int j = 0; j < n; ++j)
                list[j] = scores[j][i];
            
            Arrays.sort(list);
            
            if ((scores[i][i] == list[0] && list[0] != list[1]) || (scores[i][i] == list[n - 1] && list[n - 1] != list[n - 2]))
                scores[i][i] = -1;
            
            int k = n;
            double sum = 0;
            for (int j = 0; j < n; ++j) {
                if (scores[j][i] != -1)
                    sum += scores[j][i];
                else
                    k--;
            }
            
            double average =  sum /  k;
            if (average >= 90)
                sb.append("A");
            else if (average >= 80)
                sb.append("B");
            else if (average >= 70)
                sb.append("C");
            else if (average >= 50)
                sb.append("D");
            else
                sb.append("F");
        }
        
        return sb.toString();
    }
}
