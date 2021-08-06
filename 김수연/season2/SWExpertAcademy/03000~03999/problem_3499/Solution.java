package problem_3499;

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
			String[] list = new String[n];
			for (int i = 0; i < n; i++)
				list[i] = st.nextToken();
			
			bw.write("#" + test_case);
			if (n % 2 == 0) {
				for (int i = 0; i < n / 2; i++) {
					bw.write(" " + list[i]);
					bw.write(" " + list[i + n / 2]);
				}
			} else {
				for (int i = 0; i < n / 2; i++) {
					bw.write(" " + list[i]);
					bw.write(" " + list[i + 1 + n / 2]);
				}
				bw.write(" " + list[n / 2]);
			}
			bw.write("\n");
		}
		bw.close();
	}
}
