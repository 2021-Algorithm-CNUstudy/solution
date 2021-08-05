package problem_1961;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					arr[i][j] = scan.nextInt();
			}
			
			String[][] answer = new String[N][3];
			
			// 90
			for (int i = 0; i < N; i++) {
				String value = "";
				for (int j = N - 1; j >= 0; j--)
					value += Integer.toString(arr[j][i]);
				answer[i][0] = value;				
			}
			
			// 180
			int index = 0;
			for (int i = N - 1; i >= 0; i--) {
				String value = "";
				for (int j = N - 1; j >= 0; j--)
					value += Integer.toString(arr[i][j]);
				answer[index++][1] = value;
			}
			
			// 270
			index = 0;
			for (int i = N - 1; i >= 0; i--) {
				String value = "";
				for (int j = 0; j < N; j++)
					value += Integer.toString(arr[j][i]);
				answer[index++][2] = value;
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++)
					System.out.print(answer[i][j] + " ");
				System.out.println();
			}
		}
		
		scan.close();
	}
}
