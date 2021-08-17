package problem_11856;

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
			int[] list = new int[26];
			for (int i = 0; i < 4; ++i)
				++list[input.charAt(i) - 'A'];

			int count = 0;
			for (int i = 0; i < 26; ++i)
				if (list[i] == 2) ++count;
			
			String output = "No";
			if (count == 2)
				output = "Yes";
			
			bw.write("#" + test_case + " " + output + "\n");
		}
		br.close();
		bw.close();
	}
}