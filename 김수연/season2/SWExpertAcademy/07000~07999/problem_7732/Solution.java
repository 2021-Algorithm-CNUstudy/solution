package problem_7732;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			String[] time = br.readLine().split(":");
			int[] time1 = new int[3];
			for (int i = 0; i < 3; ++i)
				time1[i] = Integer.parseInt(time[i]);
			
			time = br.readLine().split(":");
			int[] time2 = new int[3];
			for (int i = 0; i < 3; ++i)
				time2[i] = Integer.parseInt(time[i]);
			
			for (int i = 0; i < 3; ++i)
				time1[i] = time2[i] - time1[i];
			
			if (time1[2] < 0) {
				time1[2] += 60;
				--time1[1];
			}
			
			if (time1[1] < 0) {
				time1[1] += 60;
				--time1[0];
			}
			
			if (time1[0] < 0)
				time1[0] += 24;
			
			for (int i = 0; i < 3; ++i) {
				time[i] = String.valueOf(time1[i]);
				
				if (time1[i] < 10)
					time[i] = "0" + time[i];
			}
			
			bw.write("#" + test_case + " " + time[0] + ":" + time[1] + ":" + time[2] + "\n");
		}
		br.close();
		bw.close();
	}
}