package problem_1970;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = scan.nextInt();
			int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] count = new int[8];
			
			for (int i = 0; i < 8; i++) {
				count[i] = n / money[i];
				n -= (count[i] * money[i]);
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < 8; i++)
				System.out.print(count[i] + " ");
			System.out.println();
		}
		
		scan.close();
	}
}
