package problem_10912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			String input = br.readLine();
			
			ArrayList<Character> list = new ArrayList<>();
			for (int i = 0; i < input.length(); ++i)
				list.add(input.charAt(i));
			Collections.sort(list);
			
			for (int i = 0; i < list.size() - 1; ++i) {
				char first = list.get(i);
				char second = list.get(i + 1);
				
				if (first == second) {
					list.remove(i);
					list.remove(i);
					
					--i;
				}
			}
			
			String output;
			if (list.size() == 0)
				output = "Good";
			else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < list.size(); ++i)
					sb.append(list.get(i));
				output = sb.toString();
			}
			
			bw.write("#" + test_case + " " + output + "\n");
		}
		br.close();
		bw.close();
	}
}