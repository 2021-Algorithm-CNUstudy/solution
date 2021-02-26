package Practice;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[][] maze = new int[N][M]; 
		for (int i = 0; i < N; i++) {
			String s = input.next();
			String[] temp = s.split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(temp[j]);
			}
		}
		int answer = bfs(maze, N, M);
		System.out.println(answer);
	}
		
	public static int bfs(int[][] maze, int N, int M) {
		Queue <Integer[]> q = new LinkedList<>();
		int [][] visited = new int[N][M];
		visited [0][0] = -1; // -1은 방문됨을 의미
		Integer[] start = {0, 0};
		q.offer(start);
		int [] x_move = {0, 0, -1, 1};
		int [] y_move = {-1, 1, 0, 0};
		while(!q.isEmpty()) {
			Integer [] coor = q.poll();
			int x = coor[0];
			int y = coor[1];
			visited[x][y] = -1;
			for(int i = 0; i < 4; i++) {
				int xx = x + x_move[i];
				int yy = y + y_move[i];
				if(xx < 0 || yy < 0 || xx >= N || yy >= M) {
					continue;
				}
				if(maze[xx][yy] == 1 && visited[xx][yy] != -1) {
					visited[xx][yy] = -1;
					maze[xx][yy] = maze[x][y] + 1;
					Integer [] temp = {xx, yy};
					q.offer(temp);
				}
			}
		}
		int result = maze[N - 1][M - 1];
		return result;
	}
}
