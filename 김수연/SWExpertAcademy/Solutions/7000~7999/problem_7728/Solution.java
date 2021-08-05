package problem_7728;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = Integer.parseInt(scan.nextLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String input = scan.nextLine();

			boolean[] list = new boolean[10];
			for (int index = 0; index < input.length(); index++) {
				int check = Integer.parseInt(Character.toString(input.charAt(index)));
				list[check] = true;
			}
			
			int answer = 0;
			for (int index = 0; index < list.length; index++) {
				if (list[index] == true)
					answer++;
			}
			
			System.out.println("#" + test_case + " " + answer);
		}

		scan.close();
	}
}
