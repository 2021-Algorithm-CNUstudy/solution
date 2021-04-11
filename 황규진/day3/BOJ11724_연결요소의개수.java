package day3;

import java.util.Scanner;

public class BOJ11724_연결요소의개수 {
	static int[][] arr;
	static boolean[] visited;
	static int N,M;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		int count = 0;
		if(M == 0)
			count = N;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(visited[j] == false && arr[i][j] == 1) {
					visited[j] = true;
					visited[i] = true;
					count++;
					dfs(j);
					dfs(i);
				}
				
			}
		}
		for (int i = 1; i < visited.length; i++) {
			if(visited[i] == false)
				count++;
		}
		System.out.println(count);
	}
	public static void dfs(int n) {
		for (int i = 1; i < N+1; i++) {
			if(visited[i] == false && arr[n][i] == 1) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

}
