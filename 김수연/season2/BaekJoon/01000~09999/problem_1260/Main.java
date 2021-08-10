package problem_1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, m, v;
	static boolean[] checked;
	static int[][] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		arr = new int[1001][1001];
		
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
			
		sb = new StringBuilder("");
		dfs(v);
		bw.write(sb.append("\n").toString());
		
		sb = new StringBuilder("");
		bfs();
		bw.write(sb.append("\n").toString());
		
		br.close();
		bw.close();
	}
	
	private static void dfs(int start) {
		checked = new boolean[1001];
		Stack<Integer> stack = new Stack<>();
		
		stack.add(start);
		checked[start] = true;
		sb.append(start + " ");
		
		for (int end = 1; end <= n; ++end) {
			if (arr[start][end] == 1 && checked[end] == false)
				dfs(end);
		}
	}
	
	private static void bfs() {
		checked = new boolean[1001];
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(v);
		checked[v] = true;
		sb.append(v + " ");
		
		while (! que.isEmpty()) {
			int start = que.poll();

			for (int end = 1; end <= n; ++end) {
				if (arr[start][end] == 1 && checked[end] == false) {
					que.offer(end);
					checked[end] = true;
					sb.append(end + " ");
				}
			}
		}
	}
}