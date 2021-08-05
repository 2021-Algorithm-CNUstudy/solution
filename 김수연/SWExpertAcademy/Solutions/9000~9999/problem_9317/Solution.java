package problem_9317;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = Integer.parseInt(scan.nextLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(scan.nextLine());
			
			String a = scan.nextLine();
			String b = scan.nextLine();
			
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (a.charAt(i) == b.charAt(i))
					count++;
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		scan.close();
	}
}
