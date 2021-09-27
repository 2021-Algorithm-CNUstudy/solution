package week7;

// 문자열 압축
class Solution_4 {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= (s.length() / 2); i++) {
            int size = s.length();
            int pointer = 0;

            while (pointer + i <= s.length()) {
                String current = s.substring(pointer, pointer + i);                
                int count = 0;
                pointer += i;
                
                while (pointer + i <= s.length()) {
                    String next = s.substring(pointer, pointer + i);
                    if (current.equals(next)) {
                        count++;
                        pointer += i;
                    } else
                        break;
                }

                if (count > 0) {
                    size -= i*count;
                    
                    if (count < 9)
                        size += 1;
                    else if (count < 99)
                        size += 2;
                    else if (count < 999)
                        size += 3;
                    else
                        size += 4;
                }
            }
            answer = Math.min(answer, size);
        }

        return answer;
    }
}