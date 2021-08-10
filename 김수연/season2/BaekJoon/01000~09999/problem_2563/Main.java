package problem_2563;

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
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[100][100];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int a = 0; a < 10; ++a) {
				for (int b = 0; b < 10; ++b) {
					arr[x + a][y + b] = 1;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 100; ++j)
				sum += arr[i][j];
		}
		bw.write(String.valueOf(sum));
		
		br.close();
		bw.close();
	}
}