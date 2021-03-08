package Practice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		for(int i = 0; i < testcase; i++) {
			int N = input.nextInt();
			int [][] sticker = new int[2][N];
			for(int j = 0; j < N; j++) {
				sticker[0][j] = input.nextInt();
			}
			for(int j = 0; j < N; j++) {
				sticker[1][j] = input.nextInt();
			}
			
			// 0번째나 N-1번째 줄에 있는 스티커는 무조건 뽑힌다는 것에 초점을 두고 풀어보자
			int [][] score_sum = new int[2][N];
			score_sum = sticker;
			score_sum[0][1] += score_sum[1][0];
			score_sum[1][1] += score_sum[0][0];
			for(int j = 2; j < N; j++) {
				score_sum[0][j] += Math.max(score_sum[1][j - 1], score_sum[1][j - 2]);
				score_sum[1][j] += Math.max(score_sum[0][j - 1], score_sum[0][j - 2]);
			}
			int max = Math.max(score_sum[0][N - 1], score_sum[1][N - 1]);
			System.out.println(max);
		}
	}
}
