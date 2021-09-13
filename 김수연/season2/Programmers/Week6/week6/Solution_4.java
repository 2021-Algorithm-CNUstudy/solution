package week6;

// 카카오프렌즈 컬러링북
class Solution_4 {
    int count = 0;
    int total = 0;
    int max = 0;
    int row, col;
    
    int[] di = {1, -1, 0, 0};
    int[] dj = {0, 0, 1, -1};
    
    boolean[][] check;
    int[][] board;
    
    public int[] solution(int m, int n, int[][] picture) {
        row = m;
        col = n;
        
        board = new int[m][n];
        check = new boolean[m][n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                board[i][j] = picture[i][j];
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(i, j, picture[i][j]);
                
                if (count > 0)
                    ++total;
                if (count > max)
                    max = count;
                count = 0;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = total;
        answer[1] = max;
        return answer;
    }
    
    public void dfs(int i, int j, int color) {
        // 배열의 크기를 넘어서는 경우
        if (i < 0 || j < 0 || i >= row || j >= col)
            return;
        
        // 이미 체크한 곳인 경우
        if (check[i][j])
            return;
        
        // 방문한 곳이 색이 다른 경우
        if (color != board[i][j])
            return;
        
        // 방문한 곳이 색이 없는 경우
        if (color == 0)
            return;
        
        check[i][j] = true;
        ++count;
        for (int dir = 0; dir < 4; ++dir)
            dfs(i + di[dir], j + dj[dir], color);
    }
}