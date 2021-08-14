package problem_9480;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
	static int n, r;
	static int[] indexList;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			n = Integer.parseInt(br.readLine());
			
			String[] input = new String[n];
			for (int i = 0; i < n; ++i)
				input[i] = br.readLine();
			
			list = new ArrayList<>();
			for (r = 1; r <= n; ++r) {
				indexList = new int[r];
				combination(0, 1);
			}
			
			int answer = 0;
			check: for (int i = 0; i < list.size(); ++i) {
				boolean[] check = new boolean[26];
				int[] comb = list.get(i);
				for (int j = 0; j < comb.length; ++j) {
					String temp = input[comb[j]];
					for (int k = 0; k < temp.length(); ++k)
						check[temp.charAt(k) - 97] = true;
				}
				
				for (int j = 0; j < 26; ++j) {
					if (check[j] == false)
						continue check;
				}
				
				++answer;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static void combination(int count, int start) {
		if (count == r) {
			int[] addList = new int[r];
			for (int i = 0; i < r; ++i)
				addList[i] = indexList[i];
			list.add(addList);
			return;
		}
		
		for (int i = start; i <= n; ++i) {
			indexList[count] = i - 1;
			combination(count + 1, i + 1);
		}
	}
}