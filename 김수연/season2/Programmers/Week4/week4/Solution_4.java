package week4;

// 약수의 개수와 덧셈
class Solution_4 {
    public int solution(int left, int right) {
        int length = right - left + 1;
        int[] count = new int[length];
        for (int num = 1; num <= right; ++num) {
            for (int i = 0; i < length; ++i) {
                if ((left + i) % num == 0)
                    ++count[i];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < length; ++i) {
            if (count[i] % 2 == 0)
                answer += (left + i);
            else
                answer -= (left + i);
        }
        return answer;
    }
}