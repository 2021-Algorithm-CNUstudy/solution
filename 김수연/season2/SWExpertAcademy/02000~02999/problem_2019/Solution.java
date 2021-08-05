package problem_2019;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		scan.close();
		
		int sum = 1;
		
		for (int i = 0; i < T; i++) {
			System.out.print(sum + " ");
			sum *= 2;
		}
		
		System.out.print(sum);
	}
}
