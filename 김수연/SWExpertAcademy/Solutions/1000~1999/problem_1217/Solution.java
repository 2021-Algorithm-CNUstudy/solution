package problem_1217;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			test_case = scan.nextInt();
			
			int a = scan.nextInt();
			int n = scan.nextInt();
			
			System.out.println("#" + test_case + " " + recur(a, n));
		}
		scan.close();
	}
	
	public static int recur(int a, int n) {
		if (n == 0)
			return 1;
		return a * recur(a, n - 1);
	}
}
