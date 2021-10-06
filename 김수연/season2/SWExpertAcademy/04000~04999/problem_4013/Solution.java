package problem_4013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<LinkedList<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			int k = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>(4);
			
			for (int i = 0; i < 4; ++i)
				list.add(new LinkedList<Integer>());
			
			for (int i = 0; i < 4; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; ++j)
					list.get(i).add(Integer.parseInt(st.nextToken()));
			}
			
			for (int test = 0; test < k; ++test) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				int[] rotation = new int[4];
				rotation[n] = dir;
				
				for (int i = n + 1; i < 4; ++i) {
					if (right(i - 1) == left(i))
						break;
					rotation[i] = -rotation[i - 1];
				}
				
				for (int i = n - 1; i >= 0; --i) {
					if (right(i) == left(i + 1))
						break;
					rotation[i] = -rotation[i + 1];
				}
				
				for (int i = 0; i < 4; ++i) {
					if (rotation[i] == 0)
						continue;
					
					rotate(i, rotation[i]);
				}
			}
			
			int sum = 0;
			for (int i = 0; i < 4; ++i)
				sum += (list.get(i).get(0) * (1 << i));
			
			bw.write("#" + test_case + " " + sum + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static int right(int n) {
		return list.get(n).get(2);
	}
	
	private static int left(int n) {
		return list.get(n).get(6);
	}
	
	private static void rotate(int n, int dir) {
		if (dir == 1) {
			int temp = list.get(n).remove(7);
			list.get(n).add(0, temp);
		} else if (dir == -1) {
			int temp = list.get(n).remove(0);
			list.get(n).add(temp);
		}
	}
}