package week5;

// 가운데 글자 가져오기
class Solution_5 {
    public String solution(String s) {
        int length = s.length();
        
        if (length % 2 == 1) {
            return String.valueOf(s.charAt(length / 2));
        } else {
            return String.valueOf(s.charAt(length / 2 - 1)) + String.valueOf(s.charAt(length / 2));
        }
    }
}