package problem_2805;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = Integer.parseInt(scan.nextLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(scan.nextLine());
			
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String temp = scan.nextLine();
				for (int j = 0; j < n; j++)
					arr[i][j] = temp.charAt(j) - '0';
			}
			
			int answer = 0;
			int center = n / 2;
			
			for (int i = 0; i <= n / 2; i++) {
				for (int j = center - i; j <= center + i; j++) {
					answer += arr[i][j];
				}
			}
			
			for (int i = n / 2 + 1; i < n; i++) {
				for (int j = center - (n - i) + 1; j < center + (n - i); j++)
					answer += arr[i][j];
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
