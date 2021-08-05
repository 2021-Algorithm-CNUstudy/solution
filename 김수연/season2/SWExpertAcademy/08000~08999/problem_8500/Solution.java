package problem_8500;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = scan.nextInt();
			int[] list = new int[n];
			for (int i = 0; i < n; i++)
				list[i] = scan.nextInt();
			
			Arrays.sort(list);
			
			int sum = 0;
			for (int i = 0; i < n; i++)
				sum += (list[i] + 1);
			sum += list[n-1];
			System.out.println("#" + test_case + " " + sum);
		}
		scan.close();
	}
}
