package week7;

// 같은 숫자는 싫어
public class Solution_3 {
    public int[] solution(int []arr) {
        StringBuilder sb = new StringBuilder();
        int lastElement = arr[0];
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; ++i) {
            if (lastElement == arr[i]) {
                continue;
            }
            
            sb.append(arr[i]);
            lastElement = arr[i];
        }
        
        String output = sb.toString();
        int[] answer = new int[output.length()];
        for (int i = 0; i < output.length(); ++i) {
            answer[i] = output.charAt(i) - '0';
        }
        return answer;
    }
}