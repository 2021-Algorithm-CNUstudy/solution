package problem_5948;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[7];
			for (int i = 0; i < 7; ++i)
				list[i] = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> answer = new ArrayList<>();
			
			for (int i = 0; i < 7; ++i) {
				for (int j = i + 1; j < 7; ++j) {
					for (int k = j + 1; k < 7; ++k) {
						int sum = list[i] + list[j] + list[k];
						if (! answer.contains(sum))
							answer.add(sum);
					}
				}
			}
			
			Collections.sort(answer);
			bw.write("#" + test_case + " " + answer.get(answer.size() - 5) + "\n");
		}
		br.close();
		bw.close();
	}
}