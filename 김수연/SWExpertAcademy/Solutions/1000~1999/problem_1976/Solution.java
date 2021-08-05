package problem_1976;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] timeA = new int[2];
			int[] timeB = new int[2];
			int[] answer = new int[2];
			int check = 0;
			
			for (int i = 0; i < 2; i++)
				timeA[i] = scan.nextInt();
			for (int i = 0; i < 2; i++)
				timeB[i] = scan.nextInt();
			
			int temp = timeA[1] + timeB[1];
			if (temp > 59) {
				temp -= 60;
				check++;
			}
			answer[1] = temp;
			
			temp = timeA[0] + timeB[0] + check;
			answer[0] = temp % 12;
			if (answer[0] == 0)
				answer[0] = 12;
		
			System.out.print("#" + test_case);
			for (int i = 0; i < 2; i++)
				System.out.print(" " + answer[i]);
			System.out.println();
		}
		
		scan.close();
	}
}
