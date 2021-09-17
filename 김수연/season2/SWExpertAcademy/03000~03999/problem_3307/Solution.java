package problem_3307;

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
			
			int[] list = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i)
				list[i] = Integer.parseInt(st.nextToken());
			
			int maxIndex = 0;
			int[] lis = new int[n];
			for (int i = 0; i < n; ++i) {
				lis[i] = 1;
				
				for (int j = 0; j < i; ++j) {
					if (list[i] > list[j] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
						
						if (lis[maxIndex] < lis[i])
							maxIndex = i;
					}
				}
			}
			
			bw.write("#" + test_case + " " + lis[maxIndex] + "\n");
		}
		br.close();
		bw.close();
	}
}