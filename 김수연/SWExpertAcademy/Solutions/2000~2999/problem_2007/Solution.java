package problem_2007;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = scan.next();
			int length = input.length();
			
			int answer = -1;
			char start = input.charAt(0);
			loop:
			for (int index = 1; index < length; index++) {
				int lastIndex = -1;
				if (start == input.charAt(index))
					lastIndex = index - 1;
				for (int i = 0; i <= lastIndex; i++) {
					if (input.charAt(i) != input.charAt(i + index))
						break;
					if (i == lastIndex) {
						answer = lastIndex + 1;
						break loop;
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
