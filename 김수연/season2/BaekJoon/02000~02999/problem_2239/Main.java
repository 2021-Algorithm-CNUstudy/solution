package problem_2239;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; ++i) {
			String input = br.readLine();
			for (int j = 0; j < 9; ++j)
				arr[i][j] = input.charAt(j) - '0';
		}
		
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (arr[i][j] == 0) {
					boolean[] check = new boolean[10];
					
					// 행 체크
					for (int k = 0; k < 9; ++k)
						check[arr[i][k]] = true;
					
					// 열 체크
					for (int k = 0; k < 9; ++k)
						check[arr[k][j]] = true;
					
					// 사각형 체크
					for (int k = (i / 3) * 3; k < (i / 3) * 3 + 3; ++k) {
						for (int l = (j / 3) * 3; l < (j / 3) * 3 + 3; ++l) {
							check[arr[k][l]] = true;
						}
					}
					
					for (int k = 1; k <= 9; ++k) {
						if (! check[k]) {
							arr[i][j] = k;
							break;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j)
				System.out.print(arr[i][j]);
			System.out.println();
		}
		
		br.close();
		bw.close();
	}
}