package problem;

class Solution_5 {
    public int cal(int start, int end) {
        if (start == 0)
            start = 11; // 0
        if (end == 0)
            end = 11; // 0
        
        int large, small;
        if (start > end) {
            large = start;
            small = end;
        } else if (start < end) {
            large = end;
            small = start;
        } else
            return 0;
        
        if (large % 3 == 0 && small % 3 == 0) 
            return (large / 3) - (small / 3);
        else if (large % 3 == 0)
            return (large / 3 - 1) - (small / 3) + (3 - (small % 3));
        else if (small % 3 == 0)
            return (large / 3) - (small / 3 - 1) + (3 - (large % 3));
        else
            return (large / 3) - (small / 3) + Math.abs((large % 3) - (small % 3));
    }
    
    public String solution(int[] numbers, String hand) {
        int size = numbers.length;
        int left_position = 10; // *
        int right_position = 12; // #
        String answer = "";
        
        for (int index = 0; index < size; index++) {
            int n = numbers[index];
            if (n == 1 || n == 4 || n == 7) {
                answer += "L";
                left_position = n;
            } else if (n == 3 || n == 6 || n == 9) {
                answer += "R";
                right_position = n;
            } else {
                int left_distance = cal(left_position, n);
                int right_distance = cal(right_position, n);
                
                if (left_distance < right_distance) {
                    answer += "L";
                    left_position = n;
                } else if (left_distance > right_distance) {
                    answer += "R";
                    right_position = n;
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left_position = n;
                    } else if (hand.equals("right")) {
                        answer += "R";
                        right_position = n;
                    }
                }
            }
        }
        return answer;
    }
}