package problem_1221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] list = new int[n];
			for (int i = 0; i < n; ++i) {
				String str = st.nextToken();

				if (str.equals("ZRO")) list[i] = 0;
				else if (str.equals("ONE")) list[i] = 1;
				else if (str.equals("TWO")) list[i] = 2;
				else if (str.equals("THR")) list[i] = 3;
				else if (str.equals("FOR")) list[i] = 4;
				else if (str.equals("FIV")) list[i] = 5;
				else if (str.equals("SIX")) list[i] = 6;
				else if (str.equals("SVN")) list[i] = 7;
				else if (str.equals("EGT")) list[i] = 8;
				else if (str.equals("NIN")) list[i] = 9;
			}
			
			Arrays.sort(list);
			
			bw.write("#" + test_case + "\n");
			for (int i = 0; i < n; ++i) {
				int num = list[i];
				if (num == 0) bw.write("ZRO ");
				else if (num == 1) bw.write("ONE ");
				else if (num == 2) bw.write("TWO ");
				else if (num == 3) bw.write("THR ");
				else if (num == 4) bw.write("FOR ");
				else if (num == 5) bw.write("FIV ");
				else if (num == 6) bw.write("SIX ");
				else if (num == 7) bw.write("SVN ");
				else if (num == 8) bw.write("EGT ");
				else if (num == 9) bw.write("NIN ");
			}
			bw.write("\n");
		}
		br.close();
		bw.close();
	}
}