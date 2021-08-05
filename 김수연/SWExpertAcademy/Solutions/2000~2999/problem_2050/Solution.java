package problem_2050;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String input = scan.next();
		for (int i = 0; i < input.length(); i++) {
			int output = input.charAt(i) - 64;
			
			System.out.print(output + " ");
		}
		
		scan.close();
	}
}
