package day3;

import java.util.Scanner;

public class BOJ11403_경로찾기 {
	static int[][] arr, result;
	static int N;
	static boolean[][] visited;
	static int[] memo;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		result = new int[N][N];
		visited = new boolean[N][N];
		memo = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 1 && visited[i][j] == false) {
					visited[i][j] = true;
					recursive(i, j);
					memo = new int[N];
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void recursive(int i, int j) {
		memo[i] = 1;
		if(memo[j] == 1) {
			for (int j2 = 0; j2 < memo.length; j2++) {
				for (int k = 0; k < memo.length; k++) {
					if(memo[j2] == 1 && memo[k] == 1) {
						result[j2][k] = 1;
						result[k][j2] = 1;
					}
				}
//				if(memo[j2] == 1)
//					result[j2][j2] = 1;
			}
		}
		for (int k = 0; k < N; k++) {
			if(memo[k] == 1) {
				result[k][j] = 1;
			}
		}
		for (int k = 0; k < N; k++) {
			if(arr[j][k] == 1 && visited[j][k] == false) {
				visited[j][k] = true;
				recursive(j, k);
			}
		}
		
	}

}
