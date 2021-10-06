package problem_1249;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			int[] di = {1, -1, 0, 0};
			int[] dj = {0, 0, 1, -1};
			int[][] arr = new int[n][n];
			int[][] dist = new int[n][n];
			PriorityQueue<Pos> que = new PriorityQueue<>();
			
			for (int i = 0; i < n; ++i) {
				String input = br.readLine();
				for (int j = 0; j < n; ++j)
					arr[i][j] = input.charAt(j) - '0';
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = arr[0][0];
			que.add(new Pos(0, 0, dist[0][0]));
			while (! que.isEmpty()) {
				Pos pos = que.poll();
				
				for (int dir = 0; dir < 4; ++dir) {
					int ni = pos.i + di[dir];
					int nj = pos.j + dj[dir];
					
					if (ni < 0 || ni >= n || nj < 0 || nj >= n)
						continue;
					
					if (dist[ni][nj] > arr[ni][nj] + dist[pos.i][pos.j]) {
						dist[ni][nj] = arr[ni][nj] + dist[pos.i][pos.j];
						que.add(new Pos(ni, nj, dist[ni][nj]));
					}
				}
			}
			
			bw.write("#" + test_case + " " + dist[n - 1][n - 1] + "\n");
		}
		br.close();
		bw.close();
	}
}

class Pos implements Comparable<Pos> {
	int i, j, cost;
	
	Pos (int i, int j, int cost) {
		this.i = i;
		this.j = j;
		this.cost = cost;
	}

	@Override
	public int compareTo(Pos o) {
		return this.cost - o.cost;
	}
}