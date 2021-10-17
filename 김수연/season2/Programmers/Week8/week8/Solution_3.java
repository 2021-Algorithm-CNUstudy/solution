package week8;

// 행렬 테두리 회전하기
public class Solution_3 {
	public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j)
                arr[i][j] = i * columns + j + 1;
        }
        
        int[] answer = new int[queries.length];
        for (int index = 0; index < queries.length; ++index) {
            int x1 = queries[index][0] - 1;
            int y1 = queries[index][1] - 1;
            int x2 = queries[index][2] - 1;
            int y2 = queries[index][3] - 1;
            
            int temp = arr[x1][y1];
            int min = temp;
            
            for (int i = x1; i < x2; ++i) {
                arr[i][y1] = arr[i + 1][y1];
                min = Math.min(arr[i][y1], min);
            }
            for (int j = y1; j < y2; ++j) {
                arr[x2][j] = arr[x2][j + 1];
                min = Math.min(arr[x2][j], min);
            }
            for (int i = x2 - 1; i >= x1; --i) {
                arr[i + 1][y2] = arr[i][y2];
                min = Math.min(arr[i + 1][y2], min);
            }
            for (int j = y2 - 1; j >= y1 + 1; --j) {
                arr[x1][j + 1] = arr[x1][j];
                min = Math.min(arr[x1][j + 1], min);
            }
            arr[x1][y1 + 1] = temp;
            answer[index] = min;
        }
        return answer;
    }
}