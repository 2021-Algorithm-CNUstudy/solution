package week5;

// 비밀지도
class Solution_4 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for (int i = 0; i < n; ++i) {
            
            int input = (arr1[i] | arr2[i]);
            StringBuilder sb = new StringBuilder();
            int temp = (int) Math.pow(2, n - 1);
            for (int j = 0; j < n; ++j) {
                if (input / temp == 1) {
                    sb.append("#");
                    input -= temp;
                }
                else
                    sb.append(" ");
                temp /= 2;
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}