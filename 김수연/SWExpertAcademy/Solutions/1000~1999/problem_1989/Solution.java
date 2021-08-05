package problem_1989;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = scan.next();
			char[] arr = input.toCharArray();
			
			int answer = 1;
			int length = input.length();
			
			for (int i = 0; i < (length / 2); i++) {
				if (arr[i] != arr[length - (i + 1)])
					answer = 0;
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
