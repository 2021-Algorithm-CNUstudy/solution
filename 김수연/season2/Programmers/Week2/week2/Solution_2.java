package week2;

// 로또의 최고 순위와 최저 순위
class Solution_2 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int answerCount = 0;
        for (int i = 0; i < 6; ++i) {
            if (lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            for (int j = 0; j < 6; ++j) {
                if (lottos[i] == win_nums[j]) {
                    answerCount++;
                    break;
                }
            }
        }
        
        int[] list = {1, 1};
        if (answerCount == 5)
            list[1] = 2;
        else if (answerCount == 4)
            list[1] = 3;
        else if (answerCount == 3)
            list[1] = 4;
        else if (answerCount == 2)
            list[1] = 5;
        list[0] = list[1] - zeroCount;
        
        if (answerCount <= 1) {
            list[1] = 6;
            list[0] = 6 - zeroCount;
            if (answerCount == 0 && zeroCount > 1)
                list[0]++;
        }
        
        return list;
    }
}
