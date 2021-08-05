package problem_1959;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			
			int min = (N > M) ? M : N;
			int max = (N > M) ? N : M;
			
			int[] minArr = new int[min];
			int[] maxArr = new int[max];
			
			if (N == min) {
				for (int i = 0; i < min; i++)
					minArr[i] = scan.nextInt();
				for (int i = 0; i < max; i++)
					maxArr[i] = scan.nextInt();				
			} else {
				for (int i = 0; i < max; i++)
					maxArr[i] = scan.nextInt();
				for (int i = 0; i < min; i++)
					minArr[i] = scan.nextInt();				
			}
			
			int answer = Integer.MIN_VALUE;
			for (int gap = 0; gap <= (max - min); gap++) {
				int sum = 0;
				for (int i = 0; i < min; i++) {
					sum += (minArr[i] * maxArr[i + gap]);
				}
				if (answer < sum)
					answer = sum;
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
