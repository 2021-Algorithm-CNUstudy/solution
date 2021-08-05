package problem_7272;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			String a = scan.next();
			String b = scan.next();
			String answer = "DIFF";
			
			if (a.length() == b.length()) {
				for (int i = 0; i < a.length(); i++) {
					if (check(a.charAt(i)) == check(b.charAt(i))) {
						if (i == a.length() - 1)
							answer = "SAME";
					}
					else
						break;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
	
	public static int check(char input) {
		switch (input) {
		case 'A': case 'D': case 'O': case 'P': case 'Q': case 'R':
			return 1;
		case 'B':
			return 2;
		default:
			return 0;
		}
	}
}
