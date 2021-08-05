package problem_1936;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		scan.close();
		
		if (a > b)
			System.out.println("A");
		else
			System.out.println("B");
	}
}
