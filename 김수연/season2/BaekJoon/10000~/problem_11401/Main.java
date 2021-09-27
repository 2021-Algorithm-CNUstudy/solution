package problem_11401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int p = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bw.write((nCr(n, k) % p) + "\n");
		
		br.close();
		bw.close();
	}
	
	private static long factorial(long i) {		
		long output = 1l;
		for (int j = 1; j <= i; ++j) {
			output *= j;
			output %= p;
		}
		return output;
	}
	
	private static long pow(long i, long j) {
		long output = 1l;
		while (j > 0) {
			if (j % 2 == 1) {
				output *= i;
				output %= p;
			}
			i *= i;
			i %= p;
			j /= 2;
		}
		return output % p;
	}
	
	private static long nCr(long n, long k) {
		long output = 1l;
		output *= factorial(n);
		output %= p;
		output *= pow(factorial(n - k), p - 2);
		output %= p;
		output *= pow(factorial(k), p - 2);
		output %= p;
		return output;
	}
}