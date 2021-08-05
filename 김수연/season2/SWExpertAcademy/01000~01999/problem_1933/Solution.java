package problem_1933;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		scan.close();
		
		for (int i = 1; i <= N; i++) {
			if (N % i == 0)
				System.out.print(i + " ");
		}
	}
}
