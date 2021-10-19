package week9;

// 멀쩡한 사각형
public class Solution_4 {
	public long solution(int w, int h) {
        long answer = (long)w * h;
        
        // 최대공약수 찾기
        int max = find(w, h);
        answer -= ((w / max) + (h / max) - 1) * max;
        return answer;
    }
    
    public int find(int a, int b) {
        int r = a % b;
        if (r == 0)
            return b;
        return find(b, r);
    }
}
