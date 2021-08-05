package problem_1974;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					arr[i][j] = scan.nextInt();
			}
			
			boolean[] check = new boolean[10];
			
			int answer = 1;
			
			check: {
				// 가로 검증
				for (int i = 0; i < 9; i++) {
					check = new boolean[10];
					for (int j = 0; j < 9; j++)
						check[arr[i][j]] = true;
					for (int j = 1; j <= 9; j++) {
						if (check[j] != true) {	// 틀린 경우
							answer = 0;
							break check;
						}
					}
				}
				
				// 세로 검증
				for (int i = 0; i < 9; i++) {
					check = new boolean[10];
					for (int j = 0; j < 9; j++)
						check[arr[j][i]] = true;
					for (int j = 1; j <= 9; j++) {
						if (check[j] != true) {
							answer = 0;
							break check;
						}
					}
				}
				
				// 사각형 검증
				for (int x = 0; x < 9; x += 3) {
					for (int y = 0; y < 9; y += 3) {
						check = new boolean[10];
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++)
								check[arr[i + x][j + y]] = true;
						}
						for (int j = 1; j <= 9; j++) {
							if (check[j] != true) {
								answer = 0;
								break check;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
