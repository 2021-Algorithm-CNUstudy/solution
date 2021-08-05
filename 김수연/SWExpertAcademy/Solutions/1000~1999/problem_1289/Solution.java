package problem_1289;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String input = br.readLine();
			int size = input.length();
			
			int count = 0;
			char value = '0';
			for (int i = 0; i < size; i++) {
				if (input.charAt(i) != value) {
					if (value == '0')
						value = '1';
					else
						value = '0';
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
