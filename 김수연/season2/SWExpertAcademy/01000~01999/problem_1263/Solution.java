package problem_1263;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					int input = Integer.parseInt(st.nextToken());
					if (i == j)
						arr[i][j] = 0;
					else if (input == 0)
						arr[i][j] = 10000;
					else
						arr[i][j] = input;
				}
			}
			
			for (int k = 0; k < n; ++k) {
				for (int i = 0; i < n; ++i) {
					for (int j = 0; j < n; ++j) {
						if (i == j) continue;
						if (k == i || k == j) continue;
						
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < n; ++i) {
				int sum = 0;
				for (int j = 0; j < n; ++j)
					sum += arr[i][j];
				answer = Math.min(answer, sum);
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}