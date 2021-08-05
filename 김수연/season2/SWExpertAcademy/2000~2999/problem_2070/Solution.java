package problem_2070;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			String answer = "";
			if (a > b)
				answer = ">";
			else if (a == b)
				answer = "=";
			else
				answer = "<";
			
			System.out.println("#" + (i + 1) + " " + answer);
		}
		
		scan.close();
	}
}
