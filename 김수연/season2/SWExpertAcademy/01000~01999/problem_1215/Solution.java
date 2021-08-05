package problem_1215;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		final int size = 8;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[size][size];
			
			for (int i = 0; i < size; i++) {	// 행렬 입력
				String temp = br.readLine();
				for (int j = 0; j < size; j++)
					arr[i][j] = temp.charAt(j);
			}
			
			int count = 0;
			
			// 가로 체크
			for (int i = 0; i < size; i++) {
				next1: for (int j = 0; j <= size - n; j++) {
					for (int k = 0; k < n / 2; k++) {
						if (arr[i][j + k] != arr[i][j + n - 1 - k])
							continue next1;
						if (k == n / 2 - 1)
							count++;
					}
				}
			}
			
			// 세로 체크
			for (int i = 0; i < size; i++) {
				next2: for (int j = 0; j <= size - n; j++) {
					for (int k = 0; k < n / 2; k++) {
						if (arr[j + k][i] != arr[j + n - 1 - k][i])
							continue next2;
						if (k == n / 2 - 1)
							count++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
	}
}
