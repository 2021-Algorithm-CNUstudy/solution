package problem_1149;

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
		int[][] rgb = new int[n][3];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n; ++i) {
			rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]);
			rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
			rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
		}
		
		bw.write(String.valueOf(Math.min(Math.min(rgb[n - 1][0], rgb[n - 1][1]), rgb[n - 1][2])));
		
		br.close();
		bw.close();
	}
}