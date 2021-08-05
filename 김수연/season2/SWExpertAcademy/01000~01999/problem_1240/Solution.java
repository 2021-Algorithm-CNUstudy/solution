package problem_1240;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = Integer.parseInt(scan.nextLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = scan.nextInt();
			int m = scan.nextInt();

			String password = "";
			for (int i = 0; i < n; i++) {
				String temp = scan.next();
				for (int j = m - 1; j >= 0; j--) {
					if (temp.charAt(j) == '1') {
						password = temp.substring(j - 55, j + 1);
						break;
					}
				}
			}
			
			int[] list = new int[8];
			for (int i = 0; i < 8; i++) {
				String temp = password.substring(i * 7, i * 7 + 7);
				list[i] = solve(temp);
			}
			
			System.out.println("#" + test_case + " " + cal(list));
		}
		
		scan.close();
	}
	
	private static int solve(String temp) {
		switch (temp) {
		case "0001101":
			return 0;
		case "0011001":
			return 1;
		case "0010011":
			return 2;
		case "0111101":
			return 3;
		case "0100011":
			return 4;
		case "0110001":
			return 5;
		case "0101111":
			return 6;
		case "0111011":
			return 7;
		case "0110111":
			return 8;
		case "0001011":
			return 9;
		default:
			return -1;
		}
	}
	
	private static int cal(int[] list) {
		int a = (list[0] + list[2] + list[4] + list[6]) * 3;
		int b = list[1] + list[3] + list[5] + list[7];
		if ((a + b) % 10 == 0) {
			int sum = 0;
			for (int i = 0; i < 8; i++)
				sum += list[i];
			return sum;
		}
		return 0;
	}
}
