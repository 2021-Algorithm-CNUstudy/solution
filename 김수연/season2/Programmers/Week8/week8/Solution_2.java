package week8;

// 타겟 넘버
public class Solution_2 {
	int r, answer, tar;
    int[] nums;
    boolean[] plus, input;
    
    public int solution(int[] numbers, int target) {
        r = numbers.length;
        answer = 0;
        tar = target;
        plus = new boolean[r];
        input = new boolean[] {true, false};
        nums = new int[r];
        for (int i = 0; i < r; ++i)
            nums[i] = numbers[i];
        
        permutation(0, 0);
        return answer;
    }
    
    private void permutation(int count, int flag) {
        if (count == r) {
            int score = 0;
            for (int i = 0; i < r; ++i)
                score += (plus[i]) ? nums[i] : -nums[i];
            if (score == tar)
                ++answer;
            return;
        }
        
        for (int i = 0; i < 2; ++i) {
            plus[count] = input[i];
            permutation(count + 1, flag | 1 << i);
        }
    }
}