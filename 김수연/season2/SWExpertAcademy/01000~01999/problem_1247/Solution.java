package problem_1247;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n, min;
	static int[] arr;
	static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());


			int[][] list = new int[n + 2][2];
			for (int i = 0; i < n + 2; ++i) {
				list[i][0] = Integer.parseInt(st.nextToken());
				list[i][1] = Integer.parseInt(st.nextToken());
			}
			
			distance = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; ++i) {
				for (int j = i + 1; j < n + 2; ++j) {
					distance[i][j] = dist(list[i][0], list[i][1], list[j][0], list[j][1]);
					distance[j][i] = distance[i][j];
				}
			}

			arr = new int[n];
			min = Integer.MAX_VALUE;
			permutation(0, 0);

			bw.write("#" + test_case + " " + min + "\n");
		}
		br.close();
		bw.close();
	}

	private static void permutation(int count, int flag) {
		if (count == n) {
			int dist = distance[0][arr[0]];
			for (int i = 0; i < n - 1; ++i)
				dist += distance[arr[i]][arr[i + 1]];
			dist += distance[arr[n - 1]][1];
			if (min > dist) min = dist;
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			arr[count] = i + 2;
			permutation(count + 1, flag | 1 << i);
		}
	}

	private static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}