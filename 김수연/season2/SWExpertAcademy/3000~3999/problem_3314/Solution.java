package problem_3314;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				int input = scan.nextInt();
				if (input < 40)
					sum += 40;
				else
					sum += input;
			}
			
			System.out.println("#" + test_case + " " + sum / 5);
		}
		
		scan.close();
	}
}
