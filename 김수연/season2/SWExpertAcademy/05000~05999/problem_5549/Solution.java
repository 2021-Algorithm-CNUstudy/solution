package problem_5549;

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
			int index = input.length() - 1;
			
			bw.write("#" + test_case + " ");
			if ((input.charAt(index) - '0') % 2 == 1)
				bw.write("Odd\n");
			else
				bw.write("Even\n");
		}
		bw.close();
	}
}