package problem_1208;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = scan.nextInt();
			int[] list = new int[100];
			for (int i = 0; i < 100; ++i)
				list[i] = scan.nextInt();

			Arrays.sort(list);
			int answer = list[99] - list[0];
			while (answer > 1 && n > 0) {
				list[99]--;		// max --
				list[0]++;		// min --
				n--;			// n --
				
				// 값 변동으로 인한 다시 정렬 및 측정
				Arrays.sort(list);
				answer = list[99] - list[0];
			}
			System.out.println("#" + test_case + " " + answer);
		}
		scan.close();
	}
}
