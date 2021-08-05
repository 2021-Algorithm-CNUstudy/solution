package problem_1204;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			scan.nextInt();
			int[] people = new int[101];
			for (int i = 0; i < 1000; i++)
				people[scan.nextInt()]++;
			
			int answer = 0;
			int answerIndex = 0;
			for (int i = 0; i <= 100; i++) {
				if (answer <= people[i]) {
					answer = people[i];
					answerIndex = i;
				}
			}
			
			System.out.println("#" + test_case + " " + answerIndex);
		}
		
		scan.close();
	}
}
