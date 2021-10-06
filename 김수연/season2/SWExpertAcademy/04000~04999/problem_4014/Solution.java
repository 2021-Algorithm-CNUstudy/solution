package problem_4014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n, x, answer;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			answer = 0;
			
			arr = new int[n][n];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; ++i) {
				check(i, true);
				check(i, false);
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static void check(int num, boolean isRow) {
		boolean[] check = new boolean[n];
		int[] list = new int[n];
		for (int i = 0; i < n; ++i)
			list[i] = isRow ? arr[i][num] : arr[num][i];
			
		for (int i = 0; i < n - 1; ++i) {
			if (list[i] == list[i + 1])
				continue;
			
			if (Math.abs(list[i] - list[i + 1]) > 1)
				return;
			
			if (list[i] > list[i + 1]) {
				for (int j = i + 2; j <= i + x; ++j) {
					if (j >= n || list[i + 1] != list[j])
						return;
					check[j] = true;
				}
				i += x - 1;
			} else if (list[i] < list[i + 1]) {
				for (int j = i; j > i - x; --j) {
					if (j < 0 || list[i] != list[j] || check[j])
						return;
					check[j] = true;
				}
			}
		}
		
		++answer;
	}
}