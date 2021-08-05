package problem_1220;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = scan.nextInt();
			int[][] arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = scan.nextInt();
			}
			
			int count = 0;	// 교착 상태 체크
			boolean check = false;
			for (int i = 0; i < n; i++) {			// 세로 한 줄씩 순회
				for (int j = 0; j < n; j++) {
					// 1 아래에 2가 있으면 교착상태 하나 증가 -> count++
					if (arr[j][i] == 1) {			// N극 -> 아래로 내려감
						check = true;
					} else if (arr[j][i] == 2 && check) {
						check = false;
						count++;
					}
				}
				check = false;
			}
			
			System.out.println("#" + test_case + " " + count);
		}
		
		scan.close();
	}
}
