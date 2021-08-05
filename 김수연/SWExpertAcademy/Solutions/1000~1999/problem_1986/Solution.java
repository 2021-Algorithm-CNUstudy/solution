package problem_1986;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			int answer = 1;
			boolean minus = true;
			
			for (int i = 2; i <= N; i++) {
				if (minus)
					answer -= i;
				else
					answer += i;
				
				minus = !minus;
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
