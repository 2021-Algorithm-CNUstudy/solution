package kakao;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 6;
		int[] passenger = { 1, 1, 1, 1, 1, 1 };
		int[][] train = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 5 }, { 3, 6 } };
		int distance[] = new int[n + 1];
		int[][] maps = new int[n + 1][n + 1];
		boolean[] check = new boolean[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		check[1] = true;
		for (int i = 0; i < n - 1; i++) {
			maps[train[i][0]][train[i][1]] = 1;
			maps[train[i][1]][train[i][0]] = 1;
		}
		for (int i = 1; i < n; i++) {
			if (!check[i] && maps[1][i] != 0) {
				distance[i] = passenger[i];
			}
		}
		for (int a = 0; a < n - 1; a++) {
			
		}

	}

}
