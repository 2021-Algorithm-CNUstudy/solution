package week4;

import java.util.*;

// 실패율
class Solution_3 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] answer2 = new double[N];
        
        Arrays.sort(stages);
        int theNumberOfUser = stages.length;
        
        int denominator = theNumberOfUser;
        int index = 0;
        for (int stage = 1; stage <= N; stage++) {
            int count = 0;
            if (index >= theNumberOfUser)
                break;
            if (stage == stages[index]) {
                count++;
                index++;
                while (index != theNumberOfUser) {
                    if (stages[index] == stage) {
                        count++;
                        index++;
                    }
                    else
                        break;
                }
            }
            if ((int) denominator == 0)
                answer2[stage-1] = 0;
            else
                answer2[stage-1] = (double) count / (double) denominator;
            denominator -= count;
        }
        
        int[] exceptionList = new int[N];
        Arrays.fill(exceptionList, -1);
        
        for (int i = 0; i < N; i++) {
            answer[i] = findMaxValueMinIndex(answer2, N, exceptionList) + 1;
            exceptionList[i] = answer[i] - 1;
        }
        
        return answer;
    }
    
    public int findMaxValueMinIndex(double[] list, int size, int[] exceptionIndex) {
        double max = -1;
        int index = 0;
        
        loop:
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < exceptionIndex.length; j++) {
                if (i == exceptionIndex[j])
                    continue loop;
            }
            
            if (list[i] > max) {
                index = i;
                max = list[i];
            }
        }
        
        return index;
    }
}