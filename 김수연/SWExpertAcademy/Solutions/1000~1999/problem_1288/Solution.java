package problem_1288;

import java.util.Scanner;

public class Solution {

	public static boolean check(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == false)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			
			boolean[] arr = new boolean[10];
			int count = 1;
			int last = 1;
			
			while (! check(arr)) {
				String temp = Integer.toString(N * count);
				for (int i = 0; i < temp.length(); i++) {
					int index = temp.charAt(i) - '0';
					if (arr[index] == false)
						arr[index] = true;
					last = Integer.parseInt(temp);
				}
				count++;
			}
			System.out.println("#" + test_case + " " + last);
		}
		
		scan.close();
	}
}
