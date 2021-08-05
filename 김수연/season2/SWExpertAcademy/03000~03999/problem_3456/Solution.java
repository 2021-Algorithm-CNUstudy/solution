package problem_3456;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; ++test_case) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			
			if (a == b && b == c)
				System.out.println("#" + test_case + " " + a);
			else {
				if (a == b)
					System.out.println("#" + test_case + " " + c);
				else {
					if (a == c)
						System.out.println("#" + test_case + " " + b);
				}
			}
			
		}
		scan.close();
	}
}
