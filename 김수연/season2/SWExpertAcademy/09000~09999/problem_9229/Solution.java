package problem_9229;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] list = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				list[i] = Integer.parseInt(st.nextToken());
			
			int answer = -1;
			Arrays.sort(list);
			
			for (int i = n - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					int value = list[i] + list[j];
					if (answer < value && m >= value) {
						answer = value;
						break;
					}
				}
			}
			
			bw.write("#" + test_case + " " +answer + "\n");
		}
		br.close();
		bw.close();
	}
}