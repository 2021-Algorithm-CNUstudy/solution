package problem_1545;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		scan.close();
		
		while (N != -1) {
			System.out.print(N + " ");
			N--;
		}
	}
}
