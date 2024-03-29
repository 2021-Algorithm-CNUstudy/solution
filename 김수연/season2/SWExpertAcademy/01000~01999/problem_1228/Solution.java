package problem_1228;

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
			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) 
				list.add(Integer.parseInt(st.nextToken()));
			
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for (int j = 0; j < num; j++)
					list.add(index++, Integer.parseInt(st.nextToken()));
			}
			bw.write("#" + test_case);
			for (int i = 0; i < 10; i++)
				bw.write(" " + list.get(i));
			bw.write("\n");
		}
		br.close();
		bw.close();
	}
}
