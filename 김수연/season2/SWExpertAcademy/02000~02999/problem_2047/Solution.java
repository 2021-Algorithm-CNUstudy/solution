package problem_2047;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		scan.close();
		
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if (temp >= 97 && temp <= 122)
				temp -= 32;
			
			output += Character.toString(temp);
		}
		
		System.out.println(output);
	}
}
