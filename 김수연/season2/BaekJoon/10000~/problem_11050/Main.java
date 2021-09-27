package problem_11050;

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
		
		int[][] arr = new int[11][11];
		arr[0][0] = 1;
		
		for (int i = 1; i < 11; ++i) {
			arr[i][0] = 1;
			arr[i][i] = 1;
			
			for (int j = 1; j < i; ++j)
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bw.write(arr[n][k] + "\n");
		
		br.close();
		bw.close();
	}
}