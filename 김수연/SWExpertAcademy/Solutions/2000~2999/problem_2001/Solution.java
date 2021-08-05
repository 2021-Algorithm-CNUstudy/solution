package problem_2001;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = scan.nextInt();
			}
			int max = Integer.MIN_VALUE;
			
			for (int dx = 0; dx <= (n - m); dx++) {
				for (int dy = 0; dy <= (n - m); dy++) {
					int sum = 0;
					// 파리채
					for (int px = 0; px < m; px++) {
						for (int py = 0; py < m; py++) {
							sum += arr[px + dx][py + dy];
						}
					}
					
					if (max < sum)
						max = sum;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
		
		scan.close();
	}
}
