package week8;

// 최소직사각형
public class Solution_1 {
    public int solution(int[][] sizes) {
        int maxW = 0, maxH = 0;
        for (int i = 0; i < sizes.length; ++i) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            maxW = maxW < w ? w : maxW;
            maxH = maxH < h ? h : maxH;
        }
        return maxW * maxH;
    }
}