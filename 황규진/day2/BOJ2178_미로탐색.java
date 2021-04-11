package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2178_미로탐색 {
	static int[][] arr;
	static boolean[][] visited;
	static int N,M,result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			String[] tmp2 = tmp.split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tmp2[j]);
			}
		}
		dfs(0,0,0);
		System.out.println(result);
		
	}
	public static void dfs(int x, int y, int count) {
		count++;
		if(x == N-1 && y == M-1) {
			if(result >= count) {
				result = count;
			}
			return;
		}
		visited[x][y] = true;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};
		for (int i = 0; i < dy.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false) {
				dfs(nx, ny, count);
			}
		}
	}

}
