package problem_16926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n, m, r;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < r; ++i)
			rotate(Math.min(n, m) / 2);
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		
		br.close();
		bw.close();
	}
	
	private static void rotate(int count) {
		for (int num = 0; num < count; ++num) {
			int temp = arr[num][num];
			
			int i = num, j = num + 1;
			while (check(i, j, num)) {
				arr[i][j - 1] = arr[i][j];
				++j;
			}
			
			--j;
			while (check(i + 1, j, num)) {
				arr[i][j] = arr[i + 1][j];
				++i;
			}
			
			while (check(i, j - 1, num)) {
				arr[i][j] = arr[i][j - 1];
				--j;
			}
			
			while (check(i - 1, j, num)) {
				arr[i][j] = arr[i - 1][j];
				--i;
			}
			
			arr[i + 1][j] = temp;
		}
	}
	
	private static boolean check(int i, int j, int num) {
		return i - num >= 0 && i + num < n && j - num >= 0 && j + num < m;
	}
}