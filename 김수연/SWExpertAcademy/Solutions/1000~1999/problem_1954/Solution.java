package problem_1954;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = scan.nextInt();
			
			int[][] arr = new int[n][n];
			int i = 0, j = 0, udlr = 0;
			for (int count = 1; count <= (n * n); count++) {
				int newX = i + dx[udlr], newY = j + dy[udlr];
				
				arr[i][j] = count;
				
				if (newX >= n || newX < 0 || newY >= n || newY < 0 || arr[newX][newY] != 0) {	// 나가는 경우, 숫자가 있는 경우
					if (count == (n * n)) 
						break;
					count--;
					udlr++;
					if (udlr == 4)
						udlr = 0;
					continue;
				}
				
				arr[newX][newY] = count;
				i = newX; j = newY;
			}
			
			System.out.println("#" + test_case);
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++)
					System.out.print(arr[x][y] + " ");
				System.out.println();
			}
		}
		
		scan.close();
	}
}
