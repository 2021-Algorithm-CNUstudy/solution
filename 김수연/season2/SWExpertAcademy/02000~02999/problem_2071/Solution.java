package problem_2071;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int sum = 0;
			for (int j = 0; j < 10; j++)
				sum += scan.nextInt();
			
			double average = (double)sum / 10;
			System.out.println("#" + (i + 1) + " " + String.format("%.0f", average));
		}
		
		scan.close();
	}
}
