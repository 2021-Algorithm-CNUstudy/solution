package problem_5603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			
			int sum = 0;
			int[] list = new int[n];
			for (int i = 0; i < n; ++i) {
				list[i] = Integer.parseInt(br.readLine());
				sum += list[i];
			}
			
			int answer = 0;
			int average = sum / n;
			for (int i = 0; i < n; ++i) {
				if (list[i] < average)
					answer += (average - list[i]);
			}
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}