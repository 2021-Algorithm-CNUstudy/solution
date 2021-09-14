package problem_1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1] = 0;
		
		for (int i = 1; i <= n; ++i) {
			int value = dp[i] + 1;
			
			if (i * 3 <= n)
				dp[i * 3] = dp[i * 3] > value ? value : dp[i * 3];
				
			if (i * 2 <= n)
				dp[i * 2] = dp[i * 2] > value ? value : dp[i * 2];
				
			if (i + 1 <= n)
				dp[i + 1] = dp[i + 1] > value ? value : dp[i + 1];
		}
		
		System.out.println(dp[n]);
		
		br.close();
		bw.close();
	}
}