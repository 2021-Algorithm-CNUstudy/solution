package Practice;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int [][] connection = new int[N][N];
		for(int i = 0; i < M; i++) {
			int cause = input.nextInt() - 1;
			int result = input.nextInt() - 1;
			connection[cause][result] = -1;
			connection[result][cause] = -1;
		}
		int answer = bfs(connection);
		System.out.println(answer);
	}
	
	public static int bfs(int [][] connection) {	
		int [] visited = new int[connection.length];
		visited[0] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		int cnt = 0;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i = 0; i < connection.length; i++) {
				if(connection[temp][i] == -1 && visited[i] != 1) {
					q.offer(i);
					visited[i] = 1;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
