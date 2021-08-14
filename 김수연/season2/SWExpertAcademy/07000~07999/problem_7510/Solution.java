package problem_7510;

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
			int n = Integer.parseInt(br.readLine());
			int answer = 1;
			
			int temp = 1;
			for (int i = 1; n - temp > 0; ++i) {
				if ((n - temp) % (i + 1) == 0)
					++answer;
				temp += (i + 1);
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}