package problem_2029;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			int answer1 = a / b;
			int answer2 = a % b;
			
			System.out.println("#" + (i + 1) + " " + answer1 + " " + answer2);
		}
		
		scan.close();
	}
}
