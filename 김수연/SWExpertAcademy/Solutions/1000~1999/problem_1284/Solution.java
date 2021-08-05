package problem_1284;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int P = scan.nextInt();
			int Q = scan.nextInt();
			int R = scan.nextInt();
			int S = scan.nextInt();
			int W = scan.nextInt();
			
			int A = P * W;
			int B = Q;
			if (W > R)
				B = Q + (W - R) * S;
			
			int min = (A > B) ? B : A;
			System.out.println("#" + test_case + " " + min);
		}
		
		scan.close();
	}
}
