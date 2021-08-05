package problem_1948;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] days = new int[2][2];
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++)
					days[i][j] = scan.nextInt();
			}
			
			int[] monthDays = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int answer = 0;
			
			while (days[0][0] != days[1][0]) {
				answer += days[1][1];
				days[1][1] = monthDays[--days[1][0]];
			}
			
			answer += (days[1][1] - days[0][1] + 1);
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
