package problem_4012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n, min;
	static int[] sel1, sel2;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			sel1 = new int[n / 2];
			sel2 = new int[n / 2];
			comb(0, 1);
			
			bw.write("#" + test_case + " " + min + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static void comb(int count, int start) {
		if (count == n / 2) {
			int value = 0;
			int index1 = 0;
			int index2 = 0;
			
			while (value != n) {
				if (sel1[index1] == value) ++index1;
				else sel2[index2++] = value;
				++value;
				if (index1 == n / 2) --index1;
			}
			
			int sum1 = 0;
			int sum2 = 0;
			
			for (int i = 0; i < n / 2; ++i) {
				for (int j = i + 1; j < n / 2; ++j) {
					sum1 += map[sel1[i]][sel1[j]];
					sum1 += map[sel1[j]][sel1[i]];
					sum2 += map[sel2[i]][sel2[j]];
					sum2 += map[sel2[j]][sel2[i]];
				}
			}
			
			int cal = Math.abs(sum1 - sum2);
			min = min > cal ? cal : min;
			return;
		}
		
		for (int i = start; i <= n; ++i) {
			sel1[count] = i - 1;
			comb(count + 1, i + 1);
		}
	}
}