package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1389_케빈베이컨의6단계법칙 {
	static int N,M;
	static int[][] arr;
	static boolean[] visited;
	static int[] result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		result = new int[N+1];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		for (int i = 1; i <= N; i++) {
			if(result[i]<min)
				min = result[i];
		}
		for (int i = 1; i <= N; i++) {
			if(result[i] == min) {
				System.out.println(i);
				break;
			}
		}
		

	}
	public static void bfs(int v) {
		Queue<Node> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(new Node(v,0));
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(arr[tmp.x][i] == 1 && !visited[i]) {
					queue.add(new Node(i,tmp.distance+1));
					visited[i] = true;
					result[i] += tmp.distance+1;
				}
			}
		}
	}

}
class Node {
	int x;
	int distance;
	public Node(int x, int distance) {
		this.x = x;
		this.distance = distance;
	}
}
