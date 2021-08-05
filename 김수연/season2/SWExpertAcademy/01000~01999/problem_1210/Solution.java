package problem_1210;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			test_case = scan.nextInt();
			
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++)
					arr[i][j] = scan.nextInt();
			}
			
			int destX = -1;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2)
					destX = i;
			}
			
			int x = destX;
			int y = 99;
			
			while (y != 0) {
				int[] dx = {-1, 1, 0};
				int[] dy = {0, 0, -1};
				
				for (int dir = 0; dir < dx.length; dir++) {
					int newX = x + dx[dir];
					int newY = y + dy[dir];
					if (newX < 0 || newX >= 100)
						continue;
					if (arr[newY][newX] == 1) {
						arr[newY][newX] = -1;
						x = newX;
						y = newY;
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + x);	
		}
		
		scan.close();
	}
}
