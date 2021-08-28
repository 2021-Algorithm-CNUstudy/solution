package week4;

// 직업군 추천하기
class Solution_1 {
    public String solution(String[] table, String[] languages, int[] preference) {
        int[] scores = new int[5];
        int max = -1;
        int maxIndex = -1;
        
        for (int i = 0; i < 5; ++i) {
            String input = table[i];
            String[] inputList = input.split(" ");
            for (int score = 1; score <= 5; ++score) {
                for (int j = 0; j < languages.length; ++j) {
                    if (inputList[score].equals(languages[j]))
                        scores[i] += ((6 - score) * preference[j]);
                }
            }
            if (max < scores[i]) {
                max = scores[i];
                maxIndex = i;
            } 
            
            if (max == scores[i]) {
                String a = table[maxIndex].split(" ")[0];
                String b = table[i].split(" ")[0];
                
                maxIndex = (a.charAt(0) < b.charAt(0)) ? maxIndex : i;
            }
        }
        
        return table[maxIndex].split(" ")[0];
    }
}