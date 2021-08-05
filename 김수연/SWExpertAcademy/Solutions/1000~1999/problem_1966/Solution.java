package problem_1966;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++)
				arr[i] = scan.nextInt();
			
			Arrays.sort(arr);
			
			System.out.print("#" + test_case);
			for (int i = 0; i < N; i++)
				System.out.print(" " + arr[i]);
			System.out.println();
		}
		
		scan.close();
	}
}
