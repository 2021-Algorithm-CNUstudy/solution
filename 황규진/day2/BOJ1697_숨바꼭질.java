package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		if (N == K) {
			System.out.println(0);
		} else {
			Queue<Time> queue = new LinkedList<>();
			queue.add(new Time(N, 0));
			while (!queue.isEmpty()) {
				Time p = queue.poll();
				int x = p.x;
				int time = p.time;
				if (x - 1 == K || x + 1 == K || x * 2 == K) {
					System.out.println(time + 1);
					break;
				} else {
					if (x - 1 >= 0 && !visited[x - 1]) {
						visited[x - 1] = true;
						queue.add(new Time(x - 1, time + 1));
					}
					if (x + 1 <= 100000 && !visited[x + 1]) {
						visited[x + 1] = true;
						queue.add(new Time(x + 1, time + 1));
					}
					if (x * 2 <= 100000 && !visited[x * 2]) {
						visited[x * 2] = true;
						queue.add(new Time(x * 2, time + 1));
					}
				}

			}
		}
	}

}

class Time {
	int x;
	int time;

	Time(int x, int time) {
		this.x = x;
		this.time = time;
	}
}