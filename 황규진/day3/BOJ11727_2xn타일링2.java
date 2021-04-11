package day3;

import java.util.Scanner;

public class BOJ11727_2xn타일링2 {
	static int[] memo;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[1001];
		memo[1] = 1;
		memo[2] = 3;
		
		System.out.println(dp(n));
	}
	
	public static int dp(int n) {
		if(n == 1) 
			return memo[n];
		if(n == 2)
			return memo[n];
		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i-1]%10007 + 2*memo[i-2]%10007)%10007;
		}
		return memo[n];
	}
}
