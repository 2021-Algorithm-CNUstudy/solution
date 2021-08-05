package problem_1216;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		for (int test_case = 1; test_case <= t; ++test_case) {
			test_case = Integer.parseInt(br.readLine());
			
			char [][] arr = new char[100][100];
			for (int i = 0; i < 100; ++i) {
				String line = br.readLine();
				for (int j = 0; j < 100; ++j)
					arr[i][j] = line.charAt(j);
			}
			
			int size = 100;
			loop: while (size >= 3) {
				// 가로
				for (int i = 0; i < 100; ++i) {
					for (int j = 0; j <= 100 - size; ++j) {
						StringBuilder sb = new StringBuilder();
						for (int a = 0; a < size; ++a)
							sb.append(Character.toString(arr[i][j + a]));
						if (check(sb.toString())) 
							break loop;
					}
				}
				
				// 세로
				for (int i = 0; i < 100; ++i) {
					for (int j = 0; j <= 100 - size; ++j) {
						StringBuilder sb = new StringBuilder();
						for (int a = 0; a < size; ++a)
							sb.append(Character.toString(arr[j + a][i]));
						if (check(sb.toString()))
							break loop;
					}
				}
				
				--size;
			}
			
			System.out.println("#" + test_case + " " + size);
		}
	}
	
	private static boolean check(String temp) {
		int size = temp.length();
		for (int i = 0; i < size / 2; i++) {
			if (temp.charAt(i) != temp.charAt(size - i - 1))
				return false;
		}
		return true;
	}
}
