package problem_2806;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static int n, answer;
	static int[] output;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			n = Integer.parseInt(br.readLine());

			output = new int[n];

			answer = 0;
			permutation(0, 0);

			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}

	private static void permutation(int count, int flag) {
		if (count == n) {
			int[] permList = new int[n];
			for (int i = 0; i < n; ++i)
				permList[i] = output[i];

			boolean[][] check = new boolean[n][n];
			for (int j = 0; j < n; ++j) {
				if (check[permList[j]][j])
					return;
				else {
					for (int k = 0; k < n; ++k) {
						check[permList[j]][k] = true;
						check[k][j] = true;
					}
					for (int dir = 1; dir < n && j + dir * -1 >= 0 && permList[j] + dir * -1 >= 0
							&& permList[j] + dir * -1 < n && j + dir * -1 < n; ++dir)
						check[permList[j] + dir * -1][j + dir * -1] = true;
					for (int dir = 1; dir < n && j + dir * -1 >= 0 && permList[j] + dir * 1 >= 0
							&& permList[j] + dir * 1 < n && j + dir * -1 < n; ++dir)
						check[permList[j] + dir * 1][j + dir * -1] = true;
					for (int dir = 1; dir < n && j + dir * 1 >= 0 && permList[j] + dir * -1 >= 0
							&& permList[j] + dir * -1 < n && j + dir * 1 < n; ++dir)
						check[permList[j] + dir * -1][j + dir * 1] = true;
					for (int dir = 1; dir < n && j + dir * 1 >= 0 && permList[j] + dir * 1 >= 0
							&& permList[j] + dir * 1 < n && j + dir * 1 < n; ++dir)
						check[permList[j] + dir * 1][j + dir * 1] = true;
				}
			}
			++answer;
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			output[count] = i;
			permutation(count + 1, flag | 1 << i);
		}
	}
}