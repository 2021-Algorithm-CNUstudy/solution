package problem;


class Solution_1 {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++)
            totalPrice += (long) (price * i);
        
        if (totalPrice - (long) money > 0)
            return totalPrice - (long) money;
        return 0;
    }
}
