package problem_11866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> que = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; ++i)
			que.offer(i);
		
		StringBuilder sb = new StringBuilder("<");
		for (int i = 0; i < k - 1; ++i)
			que.offer(que.poll());
		sb.append(que.poll());
		
		while (que.size() != 0) {
			for (int i = 0; i < k - 1; ++i)
				que.offer(que.poll());
			sb.append(", " + que.poll());
		}
		sb.append(">");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}