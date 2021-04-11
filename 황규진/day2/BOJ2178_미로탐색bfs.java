package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178_미로탐색bfs {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int result = 0;
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			String[] tmp2 = tmp.split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tmp2[j]);
			}
		}
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0,0));
		visited[0][0] = true;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};
		while(!queue.isEmpty()) {
			Point p = queue.poll();
//			visited[p.x][p.y] = true;
			if(p.x == N-1 && p.y == M-1) {
				result = p.count+1;
				break;
			}
			for (int i = 0; i < dy.length; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				int count = p.count + 1;
				if(nx >= 0 && nx < N && ny>=0 && ny<M && arr[nx][ny] == 1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					queue.add(new Point(nx,ny,count));
				}
			}
			
		}
		System.out.println(result);

	}
}

class Point {
	int x;
	int y;
	int count;
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//		this.count = 0;
//	}
	public Point(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
