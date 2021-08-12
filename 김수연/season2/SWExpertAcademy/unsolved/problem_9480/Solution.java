package problem_9480;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	static int n, answer;
	static boolean[] check;
	static String[] input, output;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			n = Integer.parseInt(br.readLine());
			
			input = new String[n];
			for (int i = 0; i < n; ++i)
				input[i] = br.readLine();
			
			check = new boolean[26];
			output = new String[n];
			
			answer = 0;
			combination(0, 1);
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static void combination(int count, int start) {
		if (check()) {
			System.out.println(Arrays.toString(output));
			answer++;
			check = new boolean[26];
			return;
		}
		
		if (count == n)
			return;
		
		for (int i = start; i <= n; ++i) {
			
			String temp = input[i - 1];
			for (int j = 0; j < temp.length(); ++j)
				check[temp.charAt(j) - 97] = true;
			
			output[count] = temp;
			combination(count + 1, i + 1);
		}
	}
	
	private static boolean check() {
		for (int i = 0; i < 26; ++i) {
			if (! check[i])
				return false;
		}
		return true;
	}
}