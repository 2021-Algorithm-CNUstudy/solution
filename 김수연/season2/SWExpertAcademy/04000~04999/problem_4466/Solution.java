package problem_4466;

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
			int k = Integer.parseInt(st.nextToken());
			
			int[] list = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				list[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(list);
			
			int sum = 0;
			int index = n - 1;
			while (k != 0) {
				sum += list[index--];
				k--;
			}
			
			bw.write("#" + test_case + " " + sum + "\n");
		}
		bw.close();
	}
}