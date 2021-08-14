package problem_10804;

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
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int i = input.length() - 1; i >= 0; --i) {
				char ch = input.charAt(i);
				if (ch == 'q')
					sb.append("p");
				else if (ch == 'p')
					sb.append("q");
				else if (ch == 'd')
					sb.append("b");
				else if (ch == 'b')
					sb.append("d");
			}
			
			bw.write("#" + test_case + " " + sb.toString() + "\n");
		}
		br.close();
		bw.close();
	}
}