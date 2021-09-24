package problem_1681;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static boolean[] check;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		check = new boolean[n];
		
		dfs(0, 0);
		
		bw.write(answer + "\n");
		
		br.close();
		bw.close();
	}
	
	private static void dfs(int start, int cost) {
		if (cost >= answer)
			return;
		
		if (count() == check.length - 1) {
			if (arr[start][0] == 0)
				return;
			answer = Math.min(answer, cost + arr[start][0]);
			return;
		}
		
		for (int i = 1; i < check.length; ++i) {
			if (! check[i] && arr[start][i] != 0) {
				check[i] = true;
				dfs(i, cost + arr[start][i]);
				check[i] = false;
			}
		}
	}
	
	private static int count() {
		int count = 0;
		for (int i = 0; i < check.length; ++i) {
			if (check[i])
				++count;
		}
		return count;
	}
}