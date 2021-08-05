package problem_5601;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = scan.nextInt();
			
			System.out.print("#" + test_case);
			for (int i = 0; i < n; i++)
				System.out.print(" 1/" + n);
			System.out.println();
		}
		
		scan.close();
	}
}
