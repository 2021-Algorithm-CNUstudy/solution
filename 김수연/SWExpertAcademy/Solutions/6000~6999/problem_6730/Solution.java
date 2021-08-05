package problem_6730;

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
			
			int up = 0;
			int down = 0;
			
			for (int i = 0; i < n - 1; i++) {
				int a = arr[i];
				int b = arr[i + 1];
				if (a < b) {
					if (up < (b - a))
						up = b - a;
				} else if (a > b) {
					if (down < (a - b))
						down = a - b;
				}
			}
			
			System.out.println("#" + test_case + " " + up + " " + down);
		}
		
		scan.close();
	}
}
