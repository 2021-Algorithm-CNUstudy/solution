package problem_10505;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = scan.nextInt();
			int[] list = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				list[i] = scan.nextInt();
				sum += list[i];
			}
			
			double average = (double)sum / n;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (average >= list[i])
					count++;
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		scan.close();
	}
}
