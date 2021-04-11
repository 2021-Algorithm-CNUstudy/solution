package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576_토마토 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		Queue<Point2> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					queue.add(new Point2(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		int result = 0;
		while (!queue.isEmpty()) {
			Point2 p = queue.poll();
			for (int i = 0; i < dy.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int day = p.day + 1;
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false && arr[nx][ny] == 0) {
					visited[nx][ny] = true;
					arr[nx][ny] = 1;
					queue.add(new Point2(nx, ny, day));
				}
				result = day-1;
			}
		}
		boolean check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					check = true;
			}
		}
		if (check) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

}

class Point2 {
	int x;
	int y;
	int day;

	public Point2(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}