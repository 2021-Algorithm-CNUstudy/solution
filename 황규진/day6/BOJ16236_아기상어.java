package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236_아기상어 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<Shark> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					visited[i][j] = true;
					queue.add(new Shark(i, j, 0, 2, 0));
					arr[i][j] = 0;
				}
			}
		}
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		Shark result = new Shark(0,0,0,0,0);
		while (!queue.isEmpty()) {
			Shark shark = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + shark.x;
				int ny = dy[i] + shark.y;
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == false && arr[nx][ny] <= shark.size) {
					if (arr[nx][ny] != 0) {
						if (arr[nx][ny] < shark.size) {
							shark.count++;
							if (shark.size == shark.count) {
								shark.size++;
								shark.count = 0;
							}
							shark.x = nx;
							shark.y = ny;
							shark.distance++;
							queue.clear();
							visited = new boolean[N][N];
							visited[nx][ny] = true;
							queue.add(shark);
							arr[nx][ny] = 0;
							result = new Shark(shark.x,shark.y,shark.distance,shark.size,shark.count);
							break;
						} else if (arr[nx][ny] == shark.size) {
							Shark tmp = new Shark(shark.x,shark.y,shark.distance,shark.size,shark.count);
							tmp.x = nx;
							tmp.y = ny;
							tmp.distance++;
							visited[nx][ny] = true;
							queue.add(tmp);
						}
					} else {
						Shark tmp = new Shark(shark.x,shark.y,shark.distance,shark.size,shark.count);
						tmp.x = nx;
						tmp.y = ny;
						tmp.distance++;
						visited[nx][ny] = true;
						queue.add(tmp);
					}
				}
			}
//			if(queue.isEmpty()) {
//				System.out.println(shark.distance);
//			}
		}
		System.out.println(result.distance);

	}

}

class Shark {
	int x;
	int y;
	int distance;
	int size;
	int count;

	public Shark(int x, int y, int distance, int size, int count) {
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.size = size;
		this.count = count;
	}
}