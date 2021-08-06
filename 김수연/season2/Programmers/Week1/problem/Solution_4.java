package problem;

class Solution_4 {
    public int solution(int[] nums) {
        int n = nums.length;
        int[] count = new int[200001];
        int num = 0;

        for (int i = 0; i < n; i++)
            count[nums[i]]++;
        for (int i = 1; i <= 200000; i++) {
            if (count[i] != 0)
                num++;
        }
        
        return Math.min(n / 2, num);
    }
}
