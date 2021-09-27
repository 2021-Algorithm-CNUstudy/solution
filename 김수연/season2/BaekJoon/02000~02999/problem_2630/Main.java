package problem_2630;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		
		br.close();
		bw.close();
	}
	
	public static void recur(int n) {
		int color = arr[0][0];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (color != arr[i][j]) {
					
				}
			}
		}
	}
}