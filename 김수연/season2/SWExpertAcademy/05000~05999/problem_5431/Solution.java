package problem_5431;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			
			int[] list = new int[n];
			for (int i = 0; i < k; i++) {
				int input = scan.nextInt();
				list[input - 1] = input;
			}
						
			System.out.print("#" + test_case);
			for (int i = 0; i < n; i++) {
				if (list[i] == 0)
					System.out.print(" " + (i + 1));
			}
			System.out.println();
		}
		scan.close();
	}
}
