package problem_1953;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][m];
			boolean[][] isVisited = new boolean[n][m];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; ++j)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int[] di = {-1, 1, 0, 0};
			int[] dj = {0, 0, -1, 1};
			
			Queue<Pos> que = new LinkedList<>();
			que.offer(new Pos(r, c, 1));
			
			while (! que.isEmpty()) {
				Pos pos = que.poll();
				if (pos.time > l)
					continue;
				
				for (int dir = 0; dir < 4; ++dir) {
					isVisited[pos.i][pos.j] = true;
					
					if (arr[pos.i][pos.j] == 2) {
						if (dir == 2 || dir == 3)
							continue;
					} else if (arr[pos.i][pos.j] == 3) {
						if (dir == 0 || dir == 1)
							continue;
					} else if (arr[pos.i][pos.j] == 4) {
						if (dir == 1 || dir == 2)
							continue;
					} else if (arr[pos.i][pos.j] == 5) {
						if (dir == 0 || dir == 2)
							continue;
					} else if (arr[pos.i][pos.j] == 6) {
						if (dir == 0 || dir == 3)
							continue;
					} else if (arr[pos.i][pos.j] == 7) {
						if (dir == 1 || dir == 3)
							continue;
					}
					
					int ni = pos.i + di[dir];
					int nj = pos.j + dj[dir];
					
					if (ni < 0 || ni >= n || nj < 0 || nj >= m)
						continue;
					
					if (dir == 0) {
						if (arr[ni][nj] == 3 || arr[ni][nj] == 4 || arr[ni][nj] == 7)
							continue;
					} else if (dir == 1) {
						if (arr[ni][nj] == 3 || arr[ni][nj] == 5 || arr[ni][nj] == 6)
							continue;
					} else if (dir == 2) {
						if (arr[ni][nj] == 2 || arr[ni][nj] == 6 || arr[ni][nj] == 7)
							continue;
					} else if (dir == 3) {
						if (arr[ni][nj] == 2 || arr[ni][nj] == 4 || arr[ni][nj] == 5)
							continue;
					}
					
					if (isVisited[ni][nj])
						continue;
					
					if (arr[ni][nj] == 0)
						continue;

					que.offer(new Pos(ni, nj, pos.time + 1));
				}
			}
			
			int answer = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (isVisited[i][j])
						++answer;
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}

class Pos {
	int i, j, time;
	
	Pos(int i, int j, int time) {
		this.i = i;
		this.j = j;
		this.time = time;
	}
}