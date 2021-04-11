package Practice;

import java.util.*;

public class Main {
	static int [][] route;
	static int N;
	static int [][] visited;
	static int [][] answer;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		route = new int [N][N];
		answer = new int [N][N];
		visited = new int [N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				route[i][j] = input.nextInt();
			}
		}
		answer = route; // 이미 1인 부분들은 무조건 1
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(route[i][j] == 1 && visited[i][j] != -1) {
					visited[i][j] = -1;
					chkRoute(i, j);
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void chkRoute(int start, int end) {
		answer[start][end] = 1;
		for(int i = 0; i < N; i++) {
			if(route[end][i] == 1 && visited[start][i] != -1) {
				answer[start][i] = 1;
				visited[start][i] = -1;
				chkRoute(start, i);
			}
		}
	}
}
