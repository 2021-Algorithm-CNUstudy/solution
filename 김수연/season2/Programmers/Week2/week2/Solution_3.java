package week2;

class Solution_3 {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        String answer = "";
        for (int i = 0; i < new_id.length(); ++i) {
            char temp = new_id.charAt(i);
            if ((temp >= 'a' && temp <= 'z') || (temp >= '0' && temp <= '9') || temp == '-' || temp == '_' || temp == '.')
                answer += String.valueOf(temp);
        }
        
        // 3단계
        String answer2 = "";
        boolean dot = false;
        for (int i = 0; i < answer.length(); ++i) {
            char temp = answer.charAt(i);
            if (temp == '.' && ! dot) {
                dot = true;
                answer2 += String.valueOf(temp);
            } else if (temp != '.') {
                dot = false;
                answer2 += String.valueOf(temp);
            }
        }
        
        // 4단계
        if (answer2.charAt(answer2.length() - 1) == '.')
            answer2 = answer2.substring(0, answer2.length() - 1);
        if (answer2.length() != 0 && answer2.charAt(0) == '.')
            answer2 = answer2.substring(1, answer2.length());
        
        
        // 5단계
        if (answer2.length() == 0)
            answer2 = "a";
        
        // 6단계
        if (answer2.length() >= 16)
            answer2 = answer2.substring(0, 15);
        if (answer2.charAt(answer2.length() - 1) == '.')
            answer2 = answer2.substring(0, answer2.length() - 1);
        
        // 7단계
        char temp = answer2.charAt(answer2.length() - 1);
        while (answer2.length() < 3)
            answer2 += String.valueOf(temp);
        
        return answer2;
    }
}