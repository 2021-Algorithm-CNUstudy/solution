package problem_7102;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			
			
			if (n == m)
				System.out.println("#" + test_case + " " + (n + 1));
			else {
				int min = n > m ? m : n;
				int max = n > m ? n : m;
				
				System.out.print("#" + test_case);
				for (int i = min + 1; i <= max + 1; i++)
					System.out.print(" " + i);
				System.out.println();
			}
			
		}
		scan.close();
	}
}
