package problem_1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				list.add(Integer.parseInt(st.nextToken()));
			
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				String op = st.nextToken();
				if (op.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < y; j++)
						list.add(x++, Integer.parseInt(st.nextToken()));
				} else if (op.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < y; j++)
						list.remove(x);
				} else if (op.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < y; j++)
						list.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++)
				System.out.print(" " + list.get(i));
			System.out.println();
		}
	}
}
