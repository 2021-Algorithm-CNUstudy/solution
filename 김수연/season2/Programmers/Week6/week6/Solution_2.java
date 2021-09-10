package week6;

import java.util.ArrayList;
import java.util.Collections;

// 두 개 뽑아서 더하기
class Solution_2 {
    
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        int length = numbers.length;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int sum = numbers[i] + numbers[j];
                if (! list.contains(sum))
                    list.add(sum);
            }
        }
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}