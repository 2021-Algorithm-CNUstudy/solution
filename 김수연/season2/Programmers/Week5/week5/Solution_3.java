package week5;

// 2016년
class Solution_3 {
    public String solution(int a, int b) {
        int days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (a > 1) {
            for (int i = 0; i < a - 1; ++i)
                b += days[i];
        }
        
        if (b >= 7)
            b %= 7;
        
        if (b == 0) return "THU";
        if (b == 1) return "FRI";
        if (b == 2) return "SAT";
        if (b == 3) return "SUN";
        if (b == 4) return "MON";
        if (b == 5) return "TUE";
        if (b == 6) return "WED";
        
        return null;
    }
}