package Practice;

import java.io.*;
import java.util.*;

public class Main {
	public static int zero, one, minus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				num[i][j] = Integer.parseInt(s[j]);
			}
		}
		zero = one = minus = 0;
		dfs(num, 0, 0, N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}

	public static void dfs(int [][] arr, int row, int column, int size) {
		int standard = arr[row][column];
		int FLAG = 0;
		for(int i = row; i < row + size; i++) {
			for(int j = column; j < column + size; j++) {
				if(standard != arr[i][j]) {
					FLAG = 1; // 다른 숫자 발견
					break;
				}
			}
			if(FLAG == 1) {
				break;
			}
		}
		if(FLAG == 0) {
			switch(standard) {
			case 0:
				zero++;
				break;
			case 1:
				one++;
				break;
			case -1:
				minus++;
				break;
			}
			return;
		}
		size = size / 3;
		dfs(arr, row, column, size);
		dfs(arr, row + size, column, size);
		dfs(arr, row + size * 2, column, size);
		dfs(arr, row, column + size, size);
		dfs(arr, row + size, column + size, size);
		dfs(arr, row + size * 2, column + size, size);
		dfs(arr, row, column + size * 2, size);
		dfs(arr, row + size, column + size * 2, size);
		dfs(arr, row + size * 2, column + size * 2, size);
	}
}
