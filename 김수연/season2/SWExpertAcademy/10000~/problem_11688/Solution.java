package problem_11688;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for (int test_case = 1; test_case <= t; ++test_case) {
			String input = scan.next();
			int a = 1;
			int b = 1;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == 'L')
					b += a;
				else if (input.charAt(i) == 'R')
					a += b;
			}
			System.out.println("#" + test_case + " " + a + " " + b);
		}
		scan.close();
	}
}
