package week9;

import java.util.ArrayList;
import java.util.Arrays;

// 나누어 떨어지는 숫자 배열
public class Solution_2 {
	public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] % divisor == 0)
                list.add(arr[i]);
        }
        
        int[] answer = new int[list.size()];
        if (list.size() == 0) {
            answer = new int[] {-1};
        } else {
            for (int i = 0; i < list.size(); ++i)
                answer[i] = list.get(i);
            
            Arrays.sort(answer);
        }
        
        return answer;
    }
}
