package problem_1213;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			test_case = Integer.parseInt(scan.nextLine());
			String text = scan.nextLine();
			String sentence = scan.nextLine();
			
			int count = 0;
			for (int i = 0; i <= sentence.length() - text.length(); i++) {
				String temp = "";
				for (int j = 0; j < text.length(); j++)
					temp += Character.toString(sentence.charAt(i + j));
				if (temp.equals(text))
					count++;
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		scan.close();
	}
}
