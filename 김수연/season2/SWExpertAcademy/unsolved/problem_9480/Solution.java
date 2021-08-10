package problem_9480;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			
			String[] list = new String[n];
			for (int i = 0; i < n; ++i)
				list[i] = br.readLine();
			
			check = new boolean[26];
			
			
			bw.write("#" + test_case + " " + "\n");
		}
		br.close();
		bw.close();
	}
	
//	private static void dfs(int start, int end) {
//		
//	}
}