package problem_7465;

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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list = new int[n + 1];
			for (int i = 1; i <= n; ++i)
				list[i] = i;
			
			for (int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			boolean[] answer = new boolean[n];
			int count = 0;
			for (int i = 1; i <= n; ++i) {
				if (! answer[find(i) - 1]) {
					answer[find(i) - 1] = true;
					++count;
				}
			}
			
			bw.write("#" + test_case + " " + count + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static void union(int i, int j) {
		int ii = find(i);
		int jj = find(j);
		
		if (ii < jj) 
			list[ii] = jj;
		else 
			list[jj] = ii;
	}
	
	private static int find(int i) {
		if (list[i] == i) return i;
		return find(list[i]);
	}
}