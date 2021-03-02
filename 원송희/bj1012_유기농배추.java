package Practice;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		for(int i = 0; i < testcase; i++) {
			int M = input.nextInt();
			int N = input.nextInt();
			int K = input.nextInt();
			int [][] farm = new int[N][M];
			for(int j = 0; j < K; j++) {
				int y = input.nextInt();
				int x = input.nextInt();
				farm[x][y] = 1;
			}
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(farm[j][k] != 0) {
						dfs(j, k, farm);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int x, int y, int [][] farm) {
		int [] x_move = {0, 0, 1, -1};
		int [] y_move = {1, -1, 0, 0};
		for(int i = 0; i < 4; i++) {
			int xx = x + x_move[i];
			int yy = y + y_move[i];
			int N = farm.length;
			int M = farm[0].length;
			if(xx < 0 || xx >= N || yy < 0 || yy >= M || farm[xx][yy] == 0) {
				continue;
			}
			farm[xx][yy] = 0;
			dfs(xx, yy, farm);
		}
	}
}
