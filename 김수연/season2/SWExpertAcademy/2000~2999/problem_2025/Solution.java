package problem_2025;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		scan.close();
		
		int sum = 0;
		while (N != 0) {
			sum += N;
			N--;
		}
		
		System.out.println(sum);
	}
}
