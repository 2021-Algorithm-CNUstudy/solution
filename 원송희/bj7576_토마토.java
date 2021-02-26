package Practice;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int M = input.nextInt();
		int N = input.nextInt();
		int [][] box = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				box[i][j] = input.nextInt();
			}
		}
		int answer = bfs(box, N, M);
        if(answer == -1) {
            System.out.println(answer);
        }
        else {
        System.out.println(answer - 1);    
        }
	}
	
	public static int bfs(int[][] box, int N, int M) {
		Queue <Integer[]> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					Integer[] temp = {i, j};
					q.offer(temp);
				}
			}
		}
		while(!q.isEmpty()) {
			Integer [] coor = q.poll();
			int x = coor[0];
			int y = coor[1];
			int [] x_move = {0, 0, -1, 1};
			int [] y_move = {-1, 1, 0, 0};
			for(int i = 0; i < 4; i++) {
				int xx = x + x_move[i];
				int yy = y + y_move[i];
				if(xx < 0 || yy < 0 || xx >= N || yy >= M) {
					continue;
				}
				if(box[xx][yy] != 0) {
					continue;
				}
				box[xx][yy] = box[x][y] + 1;
				Integer [] temp = {xx, yy};
				q.offer(temp);
			}
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
				if(box[i][j] > result) {
					result = box[i][j];
				}
			}
		}
		return result;
	}
}
