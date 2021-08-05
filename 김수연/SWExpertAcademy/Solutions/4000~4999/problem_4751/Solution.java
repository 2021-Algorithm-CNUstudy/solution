package problem_4751;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = Integer.parseInt(scan.nextLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String input = scan.nextLine();
			if (input.length() == 1) {
				System.out.println("..#..");
				System.out.println(".#.#.");
				System.out.println("#." + input + ".#");
				System.out.println(".#.#.");
				System.out.println("..#..");
			} else {
				for (int i = 0; i < input.length(); i++)
					System.out.print("..#.");
				System.out.println(".");
				for (int i = 0; i < input.length(); i++)
					System.out.print(".#.#");
				System.out.println(".");
				for (int i = 0; i < input.length(); i++)
					System.out.print("#." + input.charAt(i) + ".");
				System.out.println("#");
				for (int i = 0; i < input.length(); i++)
					System.out.print(".#.#");
				System.out.println(".");
				for (int i = 0; i < input.length(); i++)
					System.out.print("..#.");
				System.out.println(".");
			}
		}
		
		scan.close();
	}
}
