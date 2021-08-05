package problem_1940;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			int[][] arr = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = scan.nextInt();
				if (arr[i][0] != 0)
					arr[i][1] = scan.nextInt();				
			}
			
			int distance = 0;
			int v = 0;
			
			for (int i = 0; i < N; i++) {
				if (arr[i][0] == 1) {	// 가속
					int a = arr[i][1];
					v += a;
				} else if (arr[i][0] == 2) {	// 감속
					int a = arr[i][1];
					v -= a;
					if (v < 0)
						v = 0;
				} else {	// 유지
					
				}
				distance += v;
			}
			
			System.out.println("#" + test_case + " " + distance);
		}
		
		scan.close();
	}
}
