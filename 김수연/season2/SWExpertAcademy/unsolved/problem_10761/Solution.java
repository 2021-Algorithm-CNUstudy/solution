package problem_10761;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; ++i) {
				String robot = st.nextToken();
				
			}
			
			int seconds = 0;
			bw.write("#" + test_case + " " + seconds + "\n");
		}
		br.close();
		bw.close();
	}
}