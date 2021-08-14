package problem_5356;

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
			String[] input = new String[5];
			for (int i = 0; i < 5; ++i)
				input[i] = br.readLine();
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 15; ++i) {
				for (int j = 0; j < 5; ++j) {
					if (input[j].length() > i)
						sb.append(input[j].charAt(i));
				}
			}
			
			bw.write("#" + test_case + " " + sb.toString() + "\n");
		}
		br.close();
		bw.close();
	}
}