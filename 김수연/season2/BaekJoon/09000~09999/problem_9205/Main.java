package problem_9205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < t; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n + 2][2];
			
			for (int i = 0; i < n + 2; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; ++j)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 거리 측정
			int[][] dist = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; ++i) {
				for (int j = 0; j < n + 2; ++j) {
					if (i == j)
						continue;
					
					// 가능 ?
					if (Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]) <= 1000)
						dist[i][j] = 1;
					else
						dist[i][j] = n + 2;
				}
			}
			
			// 플로이드-와샬
			for (int k = 0; k < n + 2; ++k) {
				for (int i = 0; i < n + 2; ++i) {
					for (int j = 0; j < n + 2; ++j) {
						dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
					}
				}
			}
			
			if (dist[0][n + 1] >= n + 2)
				bw.write("sad\n");
			else
				bw.write("happy\n");
		}
		
		
		
		br.close();
		bw.close();
	}
}