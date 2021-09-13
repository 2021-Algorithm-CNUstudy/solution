package week6;

// 단체사진 찍기
class Solution_5 {
    int answer = 0;
    char[] input = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] output = new char[8];
    int total = 0;
    String[] data2;
    
    public int solution(int n, String[] data) {
        data2 = data.clone();
        perm(0, 0);
        System.out.println(total);
        return total;
    }
    
    public void perm(int count, int flag) {
        if (count == 8) {
            for (int i = 0; i < data2.length; ++i) {
                String data = data2[i];
                
                char one = data.charAt(0);
                char two = data.charAt(2);
                int index1 = -1;
                int index2 = -1;
                
                for (int j = 0; j < 8; ++j) {
                    if (one == output[j]) {
                        index1 = j;
                        break;
                    }
                }
                
                for (int j = 0; j < 8; ++j) {
                    if (two == output[j]) {
                        index2 = j;
                        break;
                    }
                }
                
                char op = data.charAt(3);
                int num = (data.charAt(4) - '0') + 1;
                if (op == '=') {
                    if (num != Math.abs(index1 - index2)) {
                    	return;
                    }
                } else if (op == '<') {
                    if (num <= Math.abs(index1 - index2)) {
                    	return;
                    }
                } else if (op == '>') {
                    if (num >= Math.abs(index1 - index2)) {
                    	return;
                    }
                }
            }
            ++total;
            return;
        }
        
        for (int i = 0; i < 8; ++i) {
            if ((flag & 1 << i) != 0) continue;
            
            output[count] = input[i];
            perm(count + 1, flag | 1 << i);
        }
    }
}