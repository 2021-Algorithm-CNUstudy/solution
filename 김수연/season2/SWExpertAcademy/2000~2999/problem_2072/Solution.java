package problem_2072;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				int number = scan.nextInt();
				if (number % 2 == 1)
					sum += number;
			}
			System.out.println("#" + (i + 1) + " " + sum);
		}
		
		scan.close();
	}
}
