package problem_3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			bw.write("#" + test_case + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list = new int[n + 1];
			for (int i = 1; i <= n; ++i)
				list[i] = i;
			
			for (int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine());
				int input = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				int aa = find(a);
				int bb = find(b);
				
				if (input == 0) {
					if (aa > bb) list[aa] = bb;
					else list[bb] = aa;
				} else if (input == 1) {
					if (aa == bb) bw.write(String.valueOf(1));
					else bw.write(String.valueOf(0));
				}
			}
			
			bw.write("\n");
		}
		br.close();
		bw.close();
	}
	
	private static int find(int i) {
		if (list[i] == i)
			return i;
		return find(list[i]);
	}
}