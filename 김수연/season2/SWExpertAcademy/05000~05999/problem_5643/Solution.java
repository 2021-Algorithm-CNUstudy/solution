package problem_5643;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
	static int n;
	static boolean[] isVisited;
	static boolean[][] list, reverseList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			list = new boolean[n][n];
			reverseList = new boolean[n][n];
			
			for (int i = 0; i < m; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				
				list[a][b] = true;
				reverseList[b][a] = true;
			}
			
			int answer = 0;
			for (int i = 0; i < n; ++i) {
				isVisited = new boolean[n];
				dfs(i);
				
				isVisited[i] = false;
				reverseDfs(i);
				
				int check = 0;
				for (int j = 0; j < n; ++j) {
					if (isVisited[j])
						++check;
				}
				
				if (check == n)
					++answer;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static void dfs(int num) {
		if (isVisited[num])
			return;
		
		isVisited[num] = true;
		
		for (int i = 0; i < n; ++i) {
			if (list[num][i])
				dfs(i);
		}
	}
	
	private static void reverseDfs(int num) {
		if (isVisited[num])
			return;
		
		isVisited[num] = true;
		
		for (int i = 0; i < n; ++i) {
			if (reverseList[num][i])
				reverseDfs(i);
		}
	}
}
