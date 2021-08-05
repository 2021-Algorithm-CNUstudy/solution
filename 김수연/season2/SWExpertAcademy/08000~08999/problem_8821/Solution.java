package problem_8821;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; ++test_case) {
			String input = scan.next();
			
			int[] list = new int[10];
			
			for (int i = 0; i < input.length(); i++) {
				int element = input.charAt(i) - '0';
				if (list[element] == 0)
					list[element] = 1;
				else
					list[element] = 0;
			}
			
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if (list[i] != 0)
					count++;
			}
			
			System.out.println("#" + test_case + " " + count);
		}
		scan.close();
	}
}
