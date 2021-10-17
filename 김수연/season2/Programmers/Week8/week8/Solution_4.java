package week8;

// 문자열을 정수로 바꾸기
import java.util.ArrayList;

class Solution_4 {
    public int solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean first = true;
        
        for (int i = 0; i < s.length(); ++i) {
            char input = s.charAt(i);
            if (input >= '0' && input <= '9') {
                if (first)
                    list.add(input - '0');
                else
                    list.add(list.remove(list.size() - 1) * 10 + (input - '0'));
                first = false;
            }
        }
        
        if (s.charAt(0) == '-')
            list.set(0, list.get(0) * -1);
        
        return list.get(0);
    }
}