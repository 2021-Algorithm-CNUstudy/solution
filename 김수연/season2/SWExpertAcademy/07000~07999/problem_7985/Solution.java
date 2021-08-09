package problem_7985;

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
			int k = Integer.parseInt(br.readLine());
			int n = (int) Math.pow(2, k) - 1;
			int[] list = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				list[i] = Integer.parseInt(st.nextToken());
			
			bw.write("#" + test_case + " ");
			
			int index = n;
			for (int i = 0; i < k; i++) {
				int beforeIndex = index;
				index = index / 2;
				int end = (int) Math.pow(2, i);
				int interval = 0;
				
				for (int j = 0; j < end; j++) {
					bw.write(list[index + interval] + " ");
					interval += (beforeIndex + 1);
				}
				bw.write("\n");;
			}
		}
		br.close();
		bw.close();
	}
}