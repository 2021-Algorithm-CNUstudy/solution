package problem_4485;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int index = 0;
		while (n != 0) {
			int[][] arr = new int[n][n];
			int[][] dijk = new int[n][n];
			
			for (int i = 0; i < n; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j)
					arr[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dijk[i], Integer.MAX_VALUE);
			}
			
			int[] di = {1, -1, 0, 0};
			int[] dj = {0, 0, 1, -1};
			
			PriorityQueue<Pos> que = new PriorityQueue<>();
			dijk[0][0] = arr[0][0];
			
			que.offer(new Pos(0, 0, arr[0][0]));
			while (! que.isEmpty()) {
				Pos pos = que.poll();
				
				for (int dir = 0; dir < 4; ++dir) {
					int ni = pos.i + di[dir];
					int nj = pos.j + dj[dir];
					
					if (ni < 0 || ni >= n || nj < 0 || nj >= n)
						continue;
					
					if (dijk[ni][nj] > dijk[pos.i][pos.j] + arr[ni][nj]) {
						dijk[ni][nj] = dijk[pos.i][pos.j] + arr[ni][nj];
						que.offer(new Pos(ni, nj, dijk[ni][nj]));
					}
				}
			}
			
			bw.write("Problem " + ++index + ": " + dijk[n - 1][n - 1] + "\n");
			n = Integer.parseInt(br.readLine());
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