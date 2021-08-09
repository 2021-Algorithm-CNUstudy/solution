package problem_1206;

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
		
		for (int test_case = 1; test_case <= 10; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[n];
			for (int i = 0; i < n; i++)
				list[i] = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			for (int i = 2; i < n - 2; i++) {
				int height = list[i];
				
				int other1 = list[i - 2];
				int other2 = list[i - 1];
				int other3 = list[i + 1];
				int other4 = list[i + 2];
				
				int max = Math.max(Math.max(other1, other2), Math.max(other3, other4));
				height -= max;
				if (height > 0)
					answer += height;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}