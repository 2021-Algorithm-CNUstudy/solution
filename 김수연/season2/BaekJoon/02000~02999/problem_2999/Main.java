package problem_2999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int n = input.length();
		
		int r = (int) Math.sqrt(n), c = n / r;
		while (r * c != n) {
			--r;
			c = n / r;
		}
		
		char[][] arr = new char[r][c];
		int index = 0;
		for (int i = 0; i < c; ++i) {
			for (int j = 0; j < r; ++j)
				arr[j][i] = input.charAt(index++);
		}
		
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j)
				bw.write(arr[i][j]);
		}
		bw.newLine();
		
		br.close();
		bw.close();
	}
}