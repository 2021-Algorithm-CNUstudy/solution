package problem_1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i = 0; i < n; ++i) {
			String input = br.readLine();
			for (int j = 0; j < n; ++j)
				arr[i][j] = input.charAt(j);
		}
		
		bw.write(recur(n, 0, 0));
		
		br.close();
		bw.close();
	}
	
	private static String recur(int k, int di, int dj) {
		if (k < 1)
			return "";
		else {
			char start = arr[0 + di][0 + dj];
			for (int i = di; i < k + di; ++i) {
				for (int j = dj; j < k + dj; ++j) {
					if (start != arr[i][j])
						return "(" 
						+ recur(k / 2, di, dj) 
						+ recur(k / 2, di, dj + k / 2) 
						+ recur(k / 2, di + k / 2, dj) 
						+ recur(k / 2, di + k / 2, dj + k / 2)
						+ ")";
				}
			}
			return String.valueOf(start);
		}
	}
}