package problem_1945;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			
			int[] list = {2, 3, 5, 7, 11};
			int[] arr = {0, 0, 0, 0, 0};
			
			int j = 0;
			while (N != 1) {
				if (N % list[j] == 0) {
					N /= list[j];
					arr[j]++;
				} else
					j++;
			}
			
			System.out.println("#" + (i + 1) + " " + arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4]);
		}
		
		scan.close();
	}
}
