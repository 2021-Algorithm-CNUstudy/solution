package problem_1859;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++)
				arr[i] = scan.nextInt();

			long money = 0;
			int max = arr[n - 1];
			
			for (int i = n - 1; i >= 0; i--) {
				if (max < arr[i])	// max update
					max = arr[i];
				else if (max > arr[i])
					money += (long)(max - arr[i]);
			}
			
			System.out.println("#" + test_case + " " + money);
		}
		
		scan.close();
	}
}
