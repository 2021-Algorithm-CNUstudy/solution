package problem_1861;

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
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int[] answer = new int[n * n];
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < 4; k++) {
						int newI = i + dx[k];
						int newJ = j + dy[k];
						
						if (newI < 0 || newI >= n || newJ < 0 || newJ >= n)	// 범위 이탈
							continue;
						if (arr[newI][newJ] - arr[i][j] == 1)
							answer[arr[i][j] - 1]++;
					}
				}
			}
			int maxNumber = -1;
			int maxLength = -1;

			for (int i = 0; i < n * n; i++) {
				if (answer[i] == 1) {
					int length = 1;
					int index = i;
					
					int j = i + 1;
					while (answer[j] != 0 && j < n * n) {
						length++;
						j++;
					}
					length++;
					
					if (maxLength < length) {
						maxLength = length;
						maxNumber = index + 1;
					}
				}
			}
			bw.write("#" + test_case + " " + maxNumber + " " + maxLength + "\n");
		}
		bw.close();
	}
}