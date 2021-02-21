package Practice;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int [] card = new int[N];
		for(int i = 0; i < N; i++) {
			card[i] = input.nextInt();
		}
		System.out.println(Sum(card, M));
	}
	
	public static int Sum(int[] arr, int M) {
		int max_sum = 0;
		for(int i = 0; i < arr.length - 2; i++) {
			for(int j = i + 1; j < arr.length - 1; j++) {
				for(int k = j + 1; k < arr.length; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if(sum == M) {
						return sum;
					}
					if(sum < M && max_sum < sum) {
						max_sum = sum;
					}
				}
			}
		}
		return max_sum;
	}
}
