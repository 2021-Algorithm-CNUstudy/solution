package problem_3456;

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
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			bw.write("#" + test_case + " ");
			if (a == b) {
				if (a == c)
					bw.write(String.valueOf(a));
				else
					bw.write(String.valueOf(c));
			} else {
				if (a == c)
					bw.write(String.valueOf(b));
				else 
					bw.write(String.valueOf(a));
			}
			bw.write("\n");
		}
		bw.close();
	}
}