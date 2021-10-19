package week9;

// 두 정수 사이의 합
public class Solution_3 {
	public long solution(int a, int b) {
        if (a == b)
            return a;
        
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int count = max - min + 1;
        
        long answer = 0;
        if (count % 2 == 1)
            answer += ((min + max) / 2);
        
        answer += ((long) (min + max) * (count / 2));
        
        return answer;
    }
}
