package problem_10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	static char[][] arr, clone;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		clone = new char[n][n];
		for (int i = 0; i < n; ++i) {
			arr[i] = br.readLine().toCharArray();
			clone[i] = arr[i].clone();
		}
		
		bw.write(bfs(0) + " ");
		
		for (int i = 0; i < n; ++i) 
			arr[i] = clone[i].clone();
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (arr[i][j] == 'R')
					arr[i][j] = 'G';
			}
		}
		
		bw.write(bfs(0) + "\n");
		br.close();
		bw.close();
	}
	
	private static int bfs(int answer) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (arr[i][j] == 'X') continue;
				
				Queue<int[]> q = new LinkedList<>();
				char input = arr[i][j];
				arr[i][j] = 'X';
				q.add(new int[] {i, j});
				
				while (! q.isEmpty()) {
					int[] poll = q.poll();
					int a = poll[0];
					int b = poll[1];
					for (int d = 0; d < 4; ++d) {
						int ni = a + di[d];
						int nj = b + dj[d];
						
						if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
						if (arr[ni][nj] != input) continue;
						
						q.add(new int[] {ni, nj});
						arr[ni][nj] = 'X';
					}
				}
				++answer;
			}
		}
		return answer;
	}
}