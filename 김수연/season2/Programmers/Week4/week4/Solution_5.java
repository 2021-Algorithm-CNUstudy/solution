package week4;

// 3진법 뒤집기
class Solution_5 {
    public int solution(int n) {
        int temp = 1;
        while (temp * 3 <= n)
            temp *= 3;
        
        StringBuilder sb = new StringBuilder();
        
        while (temp != 0) {
            sb.append(n / temp);
            n %= temp;
            temp /= 3;
        }
        
        String input = sb.toString();
        int length = input.length();
        sb = new StringBuilder();
        for (int i = length - 1; i >= 0; --i)
            sb.append(input.charAt(i));
        
        temp = 1;
        String output = sb.toString();
        int answer = 0;
        for (int i = length - 1; i >= 0; --i) {
            int num = output.charAt(i) - '0';
            answer += (num * temp);
            temp *= 3;
        }
        
        return answer;
    }
}