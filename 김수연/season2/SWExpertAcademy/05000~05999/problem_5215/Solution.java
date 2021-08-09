package problem_5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int max;
	static int n, l;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			arr = new int[n][2]; // [0] -> score, [1] -> cal
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			bw.write("#" + test_case + " " + max + "\n");
		}
		br.close();
		bw.close();
	}

	private static void dfs(int count, int score, int cal) {
		if (count == n)	{
			if (max < score && cal <= l)
				max = score;
			return;
		}
		
		dfs(count + 1, score + arr[count][0], cal + arr[count][1]);
		dfs(count + 1, score, cal);
	}
}