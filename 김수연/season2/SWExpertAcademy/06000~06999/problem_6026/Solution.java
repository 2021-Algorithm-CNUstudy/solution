package problem_6026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int p = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Integer.parseInt(st.nextToken());
			long r = Integer.parseInt(st.nextToken());
			
			long answer = nPr(n, r);
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
	
	// 중복순열이지만, 최소 한번씩은 사용해야 한다.
	private static long nPr(long n, long r) {
		long output = 1;
		return output;
	}
	
//	private static long fact(long n) {
//		long output = 1;
//		for (long i = 2; i <= n; ++i) {
//			output *= i;
//			output %= p;
//		}
//		return output;
//	}
//	
//	private static long pow(long a, long b) {
//		long output = 1;
//		while (b > 0) {
//			if (b % 2 == 1) {
//				output *= a;
//				output %= p;
//			}
//			a *= a;
//			a %= p;
//			b /= 2;
//		}
//		return output % p;
//	}
}