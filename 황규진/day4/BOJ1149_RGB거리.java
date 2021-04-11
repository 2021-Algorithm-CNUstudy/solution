package day4;

import java.util.Scanner;

public class BOJ1149_RGB거리 {
	static int N;
	static int[][] house;
	static int result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		house = new int[N][3];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				house[i][j] = sc.nextInt();
			}
		}
		comb(0, N-1, 0, 0);
		comb(0, N-1, 0, 1);
		comb(0, N-1, 0, 2);
		
		System.out.println(result);
	}
	public static void comb(int index, int end, int sum, int rgb) {
		sum = sum + house[index][rgb];
		if(sum >= result) {
			return;
		}
		if(index == end) {
			if(sum < result)
				result = sum;
			return;
		}
		
		if(rgb == 0) {
			comb(index+1, N-1, sum, 1);
			comb(index+1, N-1, sum, 2);
		} else if(rgb == 1) {
			comb(index+1, N-1, sum, 0);
			comb(index+1, N-1, sum, 2);
		} else if(rgb == 2) {
			comb(index+1, N-1, sum, 0);
			comb(index+1, N-1, sum, 1);
		}
	}

}
