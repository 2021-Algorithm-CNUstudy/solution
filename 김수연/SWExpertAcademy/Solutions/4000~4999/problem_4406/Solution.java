package problem_4406;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = Integer.parseInt(scan.nextLine().trim());
		for (int test_case = 1; test_case <= t; test_case++) {
			String input = scan.nextLine();
			String output = "";
			
			for (int i = 0; i < input.length(); i++) {
				char temp = input.charAt(i);
				if (!(temp == 'a' | temp == 'e' | temp == 'i' | temp == 'o' | temp == 'u'))
					output += Character.toString(temp);
			}
			System.out.println("#" + test_case + " " + output);
		}
		
		scan.close();
	}
}
