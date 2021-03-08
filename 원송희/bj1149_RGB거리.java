package Practice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int [][] price = new int[N][3];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				price[i][j] = input.nextInt();
			}
		}

		int [][] sum = new int[N][3];
		sum = price;
		for(int i = 1; i < N; i++) {
			sum[i][0] += Math.min(price[i - 1][1], price[i - 1][2]);
			sum[i][1] += Math.min(price[i - 1][0], price[i - 1][2]);
			sum[i][2] += Math.min(price[i - 1][0], price[i - 1][1]);
		}
		int min = Math.min(sum[N - 1][0], sum[N - 1][1]);
		min = Math.min(min, sum[N - 1][2]);
		System.out.println(min);
	}
}
