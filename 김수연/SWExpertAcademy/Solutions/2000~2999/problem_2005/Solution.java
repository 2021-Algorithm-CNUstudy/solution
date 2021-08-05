package problem_2005;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = scan.nextInt();
			int[][] answer = new int[n][n];
			
			for (int i = 0; i < n; i++)
				answer[i][0] = 1;
			
			for (int i = 1; i < n; i++) {
				for (int j = i; j > 0; j--) {
					answer[i][j] = answer[i - 1][j] + answer[i - 1][j - 1];
				}
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(answer[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		scan.close();
	}
}
