package problem_2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> que = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; ++i)
			que.offer(i);
		
		while (que.size() != 1) {
			que.poll();
			que.offer(que.poll());
		}
		
		bw.write(que.poll() + "\n");
		
		br.close();
		bw.close();
	}
}