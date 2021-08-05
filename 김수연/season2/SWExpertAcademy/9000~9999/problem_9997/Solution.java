package problem_9997;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int x = scan.nextInt();
			int hours = 0;
			int minutes = x * 2;
			
			while (minutes >= 60) {
				minutes -= 60;
				hours++;
			}
			
			if (hours == 12)
				hours = 0;
			
			System.out.println("#" + test_case + " " + hours + " " + minutes);
		}
		
		scan.close();
	}
}
