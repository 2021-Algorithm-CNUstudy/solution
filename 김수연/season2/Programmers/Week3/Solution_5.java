import java.util.*;

// 소수 만들기
class Solution_5 {
    int length, answer, maxValue;
    int[] list = new int[3];
    int[] nums2;
    boolean[] notPrimeNumbers;
    
    public int solution(int[] nums) {
        Arrays.sort(nums);
        
        length = nums.length;
        maxValue = nums[length - 1] + nums[length - 2] + nums[length - 3];
        notPrimeNumbers = new boolean[maxValue + 1];
        
        nums2 = nums.clone();
        
        makePrimeNumber();
        combination(0, 0);
        return answer;
    }
    
    private void makePrimeNumber() {
        for (int i = 2; i <= maxValue; ++i) {
            int plus = i;
            while (i + plus <= maxValue) {
                notPrimeNumbers[i + plus] = true;
                plus += i;
            }
        }
    }
    
    private void combination(int count, int start) {
        if (count == 3) {
            int sum = nums2[list[0]] + nums2[list[1]] + nums2[list[2]];
            if (! notPrimeNumbers[sum])
                ++answer;
            return;
        }
        
        for (int i = start; i < length; ++i) {
            list[count] = i;
            combination(count + 1, i + 1);
        }
    }
}