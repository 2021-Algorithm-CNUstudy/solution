package week6;

// [1차] 다트 게임
class Solution_3 {
    public int solution(String dartResult) {
        int length = dartResult.length();
        int index = 0;
        int[] list = new int[3];
        
        for (int i = 0; i < length; ++i) {
            char input1 = dartResult.charAt(i);
            
            if (input1 >= '0' && input1 <= '9') {
                char input2 = dartResult.charAt(i + 1);
                
                if (input1 == '1' && input2 == '0') {
                    char input3 = dartResult.charAt(i + 2);
                    if (input3 == 'S')
                        list[index] = 10;
                    else if (input3 == 'D')
                        list[index] = (int) Math.pow(10, 2);
                    else if (input3 == 'T')
                        list[index] = (int) Math.pow(10, 3);
                    
                } else {
                    if (input2 == 'S')
                        list[index] = input1 - '0';
                    else if (input2 == 'D')
                        list[index] = (int) Math.pow(input1 - '0', 2);
                    else if (input2 == 'T')
                        list[index] = (int) Math.pow(input1 - '0', 3);
                }
                
                ++i;
                ++index;
            } else if (input1 == '*') {
                if (index == 1) {
                    list[0] *= 2;
                } else if (index == 2 || index == 3) {
                    list[index - 1] *= 2;
                    list[index - 2] *= 2;
                }
            } else if (input1 == '#') {
                list[index - 1] *= -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < 3; ++i) {
            System.out.println(list[i]);
            sum += list[i];
        }
            
        return sum;
    }
}