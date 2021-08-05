package problem_3431;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int l = scan.nextInt();
			int u = scan.nextInt();
			int x = scan.nextInt();
			
			int answer = 0;
			
			if (l > x)
				answer = l - x;
			else if (u < x)
				answer = -1;
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
