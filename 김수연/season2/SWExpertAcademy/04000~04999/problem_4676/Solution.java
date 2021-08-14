package problem_4676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			String input = br.readLine();
			
			ArrayList<String> output = new ArrayList<>();
			output.add("");
			for (int i = 0; i < input.length(); ++i)
				output.add(Character.toString(input.charAt(i)));
			
			int h = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < h; ++i) {
				int index = Integer.parseInt(st.nextToken());
				output.set(index, output.get(index) + "-");
			}
			
			bw.write("#" + test_case + " ");
			for (int i = 0; i < output.size(); ++i)
				bw.write(output.get(i));
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}