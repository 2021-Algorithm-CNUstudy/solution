package week1;

// 모의고사
class Solution_3 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = {0, 0, 0};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5])
                count[0]++;
            if (answers[i] == two[i % 8])
                count[1]++;
            if (answers[i] == three[i % 10])
                count[2]++;
        }
            
        int max = -1;
        for (int i = 0; i < 3; i++) {
            if (max < count[i])
                max = count[i];
        }
        
        int size = 0;
        for (int i = 0; i < 3; i++) {
            if (max == count[i])
                size++;
        }
        
        int[] answer = new int[size];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (max == count[i])
                answer[index++] = i + 1;
        }
        return answer;
    }
}
