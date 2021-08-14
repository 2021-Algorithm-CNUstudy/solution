package problem_5789;

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
			int q = Integer.parseInt(st.nextToken());
			
			int[] list = new int[n];
			for (int i = 1; i <= q; ++i) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				for (int j = 0; j <= r - l; ++j)
					list[j + l] = i;
			}
			
			
			bw.write("#" + test_case);
			for (int i = 0; i < n; ++i)
				bw.write(" " + list[i]);
			bw.newLine();;
		}
		br.close();
		bw.close();
	}
}