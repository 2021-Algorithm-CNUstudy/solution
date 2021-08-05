package problem_1928;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		scan.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = scan.nextLine();
			String output = "";
			for (int i = 0; i < input.length(); i++) {
				int temp = input.charAt(i);
				if (temp >= 97)			// a-z
					temp -= 71;
				else if (temp >= 65)	// A-Z
					temp -= 65;
				else if (temp >= 48)	// 0-9
					temp += 4;
				else if (temp == 47)	// /
					temp += 16;
				else if (temp == 43)	// +
					temp += 19;
				
				String temp2 = Integer.toBinaryString(temp);
				
				while (temp2.length() != 6)
					temp2 = "0" + temp2;
				
				output += temp2;
			}
			
			String answer = "";
			while (output.length() != 0) {
				int ascii = Integer.valueOf(output.substring(0, 8), 2);
				answer += Character.toString((char)ascii);
				output = output.substring(8, output.length());
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
