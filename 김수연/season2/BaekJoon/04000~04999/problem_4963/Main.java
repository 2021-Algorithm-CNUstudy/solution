package problem_4963;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int h, w, answer;
	static int[] di = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dj = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		while (w != 0 || h != 0) {
			arr = new int[h][w];
			for (int i = 0; i < h; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; ++j)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			answer = 0;
			bfs();
			bw.write(answer + "\n");
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		bw.close();
	}
	
	private static void bfs() {
		Queue<Pos> que = new LinkedList<Pos>();
		int count = 0;
		
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				if (arr[i][j] != 1) continue;
				if (arr[i][j] == 1) {
					que.offer(new Pos(i, j));
					arr[i][j] = 2;
				}
				
				while (! que.isEmpty()) {
					Pos pos = que.poll();
					for (int dir = 0; dir < 8; ++dir) {
						int newI = pos.i + di[dir];
						int newJ = pos.j + dj[dir];
						
						if (newI < 0 || newI >= h || newJ < 0 || newJ >= w) continue;
						if (arr[newI][newJ] == 1) {
							que.offer(new Pos(newI, newJ));
							arr[newI][newJ] = 2;
						}
					}
				}
				++count;
			}
		}
		answer = count;
	}
}

class Pos {
	int i, j;
	
	Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}