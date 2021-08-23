package problem_1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int test_case = 1; test_case <= 10; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int startNumber = Integer.parseInt(st.nextToken());
			boolean[][] arr = new boolean[101][101];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; ++i)
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			
			Queue<int[]> list = new LinkedList<>();
			list.offer(new int[] {startNumber, 1});
			
			boolean[] check = new boolean[101];
			check[startNumber] = true;
			
			int maxNumber = Integer.MIN_VALUE;
			int lastTime = 0;
			
			while (! list.isEmpty()) {
				int[] poll = list.poll();
				for (int i = 0; i < 101; ++i) {
					if (check[i]) continue;
					
					if (arr[poll[0]][i]) {
						list.offer(new int[] {i, poll[1] + 1});
						check[i] = true;
					}
				}
				if (lastTime < poll[1]) {
					lastTime = poll[1];
					maxNumber = poll[0];
				} else if (lastTime == poll[1]) {
					if (maxNumber < poll[0])
						maxNumber = poll[0];
				}
			}
			
			bw.write("#" + test_case + " " + maxNumber + "\n");
		}
		br.close();
		bw.close();
	}
}