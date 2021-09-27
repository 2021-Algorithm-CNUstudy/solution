package problem_9095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] list = new int[11];
		list[0] = 0;
		list[1] = 1;
		list[2] = 2;
		list[3] = 4;
		
		for (int i = 4; i < 11; ++i)
			list[i] = list[i - 3] + list[i - 2] + list[i - 1];
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < t; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			
			bw.write(list[n] + "\n");
		}
		
		br.close();
		bw.close();
	}
}