package problem_8458;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			n = Integer.parseInt(br.readLine());
			list = new int[n];
			int max = 0;
			int answer = 0;
			int sum = 0;
			
			for (int index = 0; index < n; ++index) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int i = Math.abs(Integer.parseInt(st.nextToken()));
				int j = Math.abs(Integer.parseInt(st.nextToken()));
				list[index] = i + j;
				max = Math.max(max, i + j);
				
				if (list[index] % 2 != list[0] % 2)
					answer = -1;
			}
			
			if (answer == 0) {
				while (true) {
					boolean isEven = true;
					if (sum < max || (max - sum) % 2 != 0)
						isEven = false;
					if (isEven)
						break;
					sum += ++answer;
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}
