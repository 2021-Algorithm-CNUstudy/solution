package problem_2961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Boolean[] isSelected;
	static int[][] list;
	static ArrayList<ArrayList<Integer>> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		list = new int[n][2];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken()); 
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new Boolean[n + 1];
		set = new ArrayList<>();
		subSet(0);
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < set.size(); ++i) {
			int s = 1, b = 0;
			for (int j = 0; j < set.get(i).size(); ++j) {
				s *= list[set.get(i).get(j)][0];
				b += list[set.get(i).get(j)][1];
			}
			if (min > Math.abs(s - b))
				min = Math.abs(s - b);
		}
		bw.write(String.valueOf(min));
		
		br.close();
		bw.close();
	}
	
	private static void subSet(int count) {
		if (count == n) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				if (isSelected[i])
					temp.add(i);
			}
			
			if (temp.size() == 0)
				return;
			
			set.add(temp);
			return;
		} else {
			isSelected[count] = true;
			subSet(count + 1);
			isSelected[count] = false;
			subSet(count + 1);
		}
	}
}