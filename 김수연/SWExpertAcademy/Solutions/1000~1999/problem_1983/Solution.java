package problem_1983;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = scan.nextInt();
			int k = scan.nextInt() - 1;
			int[] list = new int[n];
			String[] answer = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			
			for (int i = 0; i < n; i++)
				list[i] = scan.nextInt() * 35 + scan.nextInt() * 45 + scan.nextInt() * 20;
		
			int score = list[k];
			Arrays.sort(list);
			int index = Arrays.binarySearch(list, score);
			index = (n - 1) - index;
			System.out.println("#" + test_case + " " + answer[index / (n / 10)]);
		}
		
		scan.close();
	}
}
