package practice;

import java.util.*;

public class Main {
	public static int[][] route;
	public static int[] visited;
	public static int N;
	public static int M;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		route = new int[1000][1000];
		for (int i = 0; i < M; i++) {
			int start = input.nextInt() - 1;
			int end = input.nextInt() - 1;
			route[start][end] = 1;
			route[end][start] = 1;
		}
		visited = new int[1000];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i] != -1) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void dfs(int V) {
		if (visited[V] == -1) {
			return;
		}
		visited[V] = -1; // 방문 체크
		for (int i = 0; i < N; i++) {
			if (route[i][V] == 1) {
				dfs(i);
			}
		}
	}
}
