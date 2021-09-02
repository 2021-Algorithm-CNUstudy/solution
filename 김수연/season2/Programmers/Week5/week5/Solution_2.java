package week5;

import java.util.Arrays;

// 예산
class Solution_2 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int i = 0;
        int sum = 0;
        for (; i < d.length; ++i) {
            sum += d[i];
            if (budget < sum)
                break;
        }
        
        return i;
    }
}