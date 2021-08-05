package problem_6913;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = Integer.parseInt(scan.nextLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(scan.next());
			int m = Integer.parseInt(scan.next());
			
			int[][] arr = new int[n][m + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					arr[i][j] = Integer.parseInt(scan.next());
			}
			
			int solutions = 0;
			for (int i = 0; i < n; i++) {
				solutions = 0;
				for (int j = 0; j < m; j++) {
					if (1 == arr[i][j])
						solutions++;
				}
				arr[i][m] = solutions;
			}
			
			int count = 0;
			int maxValue = -1;
			for (int i = 0; i < n; i++) {
				if (maxValue < arr[i][m]) {
					maxValue = arr[i][m];
					count = 1;
				} else if (maxValue == arr[i][m])
					count++;
			}
			
			System.out.println("#" + test_case + " " + count + " " + maxValue);
		}
		
		scan.close();
	}
}
