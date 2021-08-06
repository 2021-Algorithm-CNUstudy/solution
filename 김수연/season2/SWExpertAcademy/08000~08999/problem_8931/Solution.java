package problem_8931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			int k = Integer.parseInt(br.readLine());
			Stack<Integer> st = new Stack<>();
			
			for (int i = 0; i < k; i++) {
				int input = Integer.parseInt(br.readLine());
				if (input == 0)
					st.pop();
				else
					st.push(input);
			}
			
			int sum = 0;
			while (st.size() != 0)
				sum += st.pop();
			
			bw.write("#" + test_case + " " + sum + "\n");
		}
		bw.close();
	}
}