package day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019_DSLR {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			String[] answer = new String[10001];
			Arrays.fill(answer, "");
			boolean[] visited = new boolean[10001];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(A);
			visited[A] = true;
			while(!queue.isEmpty() && visited[B] == false) {
				int tmp = queue.poll();
				int D = (2*tmp)%10000;
				int S = tmp-1;
				if(S == -1)
					S = 9999;
				int L = (tmp % 1000) * 10 + tmp/1000;
				int R = (tmp % 10) * 1000 + tmp/10;
				
				if(!visited[D]) {
					queue.add(D);
					visited[D] = true;
					answer[D] = answer[tmp] + "D";
				}
				if(!visited[S]) {
					queue.add(S);
					visited[S] = true;
					answer[S] = answer[tmp] + "S";
				}
				if(!visited[L]) {
					queue.add(L);
					visited[L] = true;
					answer[L] = answer[tmp] + "L";
				}
				if(!visited[R]) {
					queue.add(R);
					visited[R] = true;
					answer[R] = answer[tmp] + "R";
				}
			}
			System.out.println(answer[B]);
		}
		
	}

}
