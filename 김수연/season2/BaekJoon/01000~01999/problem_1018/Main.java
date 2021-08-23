package problem_1018;

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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][];
		for (int i = 0; i < n; ++i)
			arr[i] = br.readLine().toCharArray();
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i <= n - 8; ++i) {
			for (int j = 0; j <= m - 8; ++j) {
				int count1 = 0, count2 = 0;
				for (int a = 0; a < 8; ++a) {
					for (int b = 0; b < 8; ++b) {
						int check = a + b + i + j;
						if (check % 2 == 1 && arr[i + a][j + b] != 'B') {
							++count1;
						} else if (check % 2 == 0 && arr[i + a][j + b] != 'W') {
							++count1;
						}
						
						if (check % 2 == 0 && arr[i + a][j + b] != 'B') {
							++count2;
						} else if (check % 2 == 1 && arr[i + a][j + b] != 'W') {
							++count2;
						}
					}
				}
				if (min > count1) min = count1;
				if (min > count2) min = count2;
			}
		}
		bw.write(min + "\n");
		
		br.close();
		bw.close();
	}
}