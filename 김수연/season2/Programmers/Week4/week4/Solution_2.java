package week4;

// 숫자 문자열과 영단어
class Solution_2 {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char input = s.charAt(i);
            
            if (input >= '0' && input <= '9') {
                sb.append(input);
                continue;
            }
            
            char nextInput = s.charAt(i + 1);
            String temp = String.valueOf(input) + String.valueOf(nextInput);
            
            if (temp.equals("on")) {
                sb.append(1);
                i += 2;
            } else if (temp.equals("tw")) {
                sb.append(2);
                i += 2;
            } else if (temp.equals("th")) {
                sb.append(3);
                i += 4;
            } else if (temp.equals("fo")) {
                sb.append(4);
                i += 3;
            } else if (temp.equals("fi")) {
                sb.append(5);
                i += 3;
            } else if (temp.equals("si")) {
                sb.append(6);
                i += 2;
            } else if (temp.equals("se")) {
                sb.append(7);
                i += 4;
            } else if (temp.equals("ei")) {
                sb.append(8);
                i += 4;
            } else if (temp.equals("ni")) {
                sb.append(9);
                i += 3;
            } else if (temp.equals("ze")) {
                sb.append(0);
                i += 3;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}