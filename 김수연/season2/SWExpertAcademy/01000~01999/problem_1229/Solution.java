package problem_1229;

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
		
		for (int test_case = 1; test_case <= 10; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++)
				list.add(st.nextToken());
			
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String input = st.nextToken();
				if (input.equals("I")) {
					int index = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					for (int j = 0; j < count; j++)
						list.add(index++, st.nextToken());
				} else if (input.equals("D")) {
					int index = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					for (int j = 0; j < count; j++)
						list.remove(index);
				}
			}
			bw.write("#" + test_case);
			for (int i = 0; i < 10; i++)
				bw.write(" " + list.get(i));
			bw.write("\n");
		}
		bw.close();
	}
}