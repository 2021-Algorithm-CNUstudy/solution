package problem_1258;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = scan.nextInt();
			int distance = 100000;
			int count = 0;
			for (int i = 0; i < n; i++) {
				int input = Math.abs(scan.nextInt());
				if (distance > input) {
					distance = input;
					count = 1;
				} else if (distance == input)
					count++;
			}
			System.out.println("#" + test_case + " " + distance + " " + count);
		}
		
		scan.close();
	}
}
