package problem_2043;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int P = scan.nextInt();
		int K = scan.nextInt();
		
		scan.close();
		
		int count = 0;
		while (P >= K) {
			K++;
			count++;
		}
		
		System.out.println(count);
	}
}
