package problem_2058;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int sum = 0;
		
		for (int i = 1000; i >= 1; i /= 10) {
			int temp = N / i;	// ¸ò
			N = N % i;			// ³ª¸ÓÁö
			sum += temp;
		}
		
		System.out.println(sum);
		
		scan.close();
	}
}
