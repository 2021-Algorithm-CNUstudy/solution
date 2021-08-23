package problem_1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r, c, answer;
	static int[] di = {0, 0, 1, -1};
	static int[] dj = {1, -1, 0, 0};
	static boolean[] check;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		for (int i = 0; i < r; ++i)
			arr[i] = br.readLine().toCharArray();
		
		check = new boolean[26];
		
		dfs(0, 0, 1);
		
		bw.write(answer + "\n");
		
		br.close();
		bw.close();
	}
	
	private static void dfs(int i, int j, int length) {
		if (check[arr[i][j] - 'A']) return;
		
		check[arr[i][j] - 'A'] = true;
		if (answer < length) answer = length;
		
		for (int dir = 0; dir < 4; ++dir) {
			int newI = i + di[dir];
			int newJ = j + dj[dir];
			
			if (newI < 0 || newI >= r || newJ < 0 || newJ >= c) continue;
			dfs(newI, newJ, length + 1);
		}
		check[arr[i][j] - 'A'] = false;
	}
}