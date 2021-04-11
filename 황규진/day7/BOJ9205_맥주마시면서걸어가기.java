package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9205_맥주마시면서걸어가기 {
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point5 home = new Point5(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point5[] conv = new Point5[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				conv[i] = new Point5(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			Point5 des = new Point5(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			boolean[] visited = new boolean[n];
			result = 0;
			dfs(home, conv, des, visited);
			if(result == 0)
				System.out.println("sad");
			else
				System.out.println("happy");
		}
	}
	public static void dfs(Point5 now, Point5[] conv, Point5 des, boolean[] visited) {
		if((Math.abs(now.x-des.x) + Math.abs(now.y-des.y)) <= 1000) {
			result = 1;
		}
		for (int i = 0; i < conv.length; i++) {
			if((Math.abs(now.x-conv[i].x) + Math.abs(now.y-conv[i].y)) <= 1000 && visited[i] == false) {
				visited[i] = true;
				dfs(conv[i], conv, des, visited);
			}
		}
	}
}
class Point5 {
	int x;
	int y;
	public Point5(int x, int y) {
		this.x = x;
		this.y = y;
	}
}