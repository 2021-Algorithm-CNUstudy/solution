package problem_8658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < 10; i++) {
				int answer = 0;
				String temp = st.nextToken();
				for (int j = 0; j < temp.length(); j++)
					answer += (temp.charAt(j) - '0');
				
				if (min > answer)
					min = answer;
				if (max < answer)
					max = answer;
			}
			
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}
