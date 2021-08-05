package problem_1984;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			
			for (int i = 0; i < 10; i++) {
				int number = scan.nextInt();
				if (min > number)
					min = number;
				if (max < number)
					max = number;
				sum += number;
			}
			
			sum -= (min + max);
			System.out.println("#" + test_case + " " + String.format("%.0f", (sum / 8.0)));
		}
		
		scan.close();
	}
}
