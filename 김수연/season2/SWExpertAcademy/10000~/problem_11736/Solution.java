package problem_11736;

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
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[n];
			for (int i = 0; i < n; ++i)
				list[i] = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			for (int i = 1; i < n - 1; ++i) {
				int a = list[i - 1];
				int b = list[i];
				int c = list[i + 1];
				
				int max = Math.max(Math.max(a, b), c);
				int min = Math.min(Math.min(a, b), c);

				if (b != max && b != min)
					++answer;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}