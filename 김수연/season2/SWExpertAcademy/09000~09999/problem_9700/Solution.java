package problem_9700;

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
			double p = Double.parseDouble(st.nextToken());
			double q = Double.parseDouble(st.nextToken());
			
			double s1 = (1 - p) * q;
			double s2 = p * (1 - q) * q;
			
			bw.write("#" + test_case + " ");
			if (s1 < s2)
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}
		bw.close();
	}
}