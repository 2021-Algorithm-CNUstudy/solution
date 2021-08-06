package problem_1209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int test_case = 1; test_case <= 10; ++test_case) {
			Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			
			// 가로
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++)
					sum += arr[i][j];
				if (sum > max)
					max = sum;
			}
			
			// 세로
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++)
					sum += arr[j][i];
				if (sum > max)
					max = sum;
			}
			
			// 대각선
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][i];
				if (sum > max)
					max = sum;
			}
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[99 - i][i];
				if (sum > max)
					max = sum;
			}
			
			bw.write("#" + test_case + " " + max + "\n");
		}
		bw.close();
	}
}