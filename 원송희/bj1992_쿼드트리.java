package Practice;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				num[i][j] = Integer.parseInt(s[j]);
			}
		}
		dfs(num, 0, 0, N);
	}

	public static void dfs(int [][] arr, int row, int column, int size) {
		if(size == 1) {
			System.out.print(arr[row][column]);
			return;
		}
		int standard = arr[row][column];
		int FLAG = 0;
		for(int i = row; i < row + size; i++) {
			for(int j = column; j < column + size; j++) {
				if(standard != arr[i][j]) {
					FLAG = 1; // 다른 숫자 발견
					break;
				}
			}
		}
		if(FLAG == 0) {
			System.out.print(arr[row][column]);
			return;
		}
		size = size / 2;
		System.out.print("(");
		dfs(arr, row, column, size);
		dfs(arr, row, column + size, size);
		dfs(arr, row + size, column, size);
		dfs(arr, row + size, column + size, size);
		System.out.print(")");
	}
}
