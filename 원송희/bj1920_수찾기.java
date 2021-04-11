package practice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		int M = input.nextInt();
		int[] arr2 = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = input.nextInt();
		}
		Arrays.sort(arr);
		for(int i = 0; i < M; i++) {
			System.out.println(BinarySearch(arr2[i], arr));
		}
	}

	public static int BinarySearch(int key, int[] arr) {
		int midIdx;
		int firstIdx = 0;
		int lastIdx = arr.length - 1;
		while (firstIdx <= lastIdx) {
			midIdx = (firstIdx + lastIdx) / 2;
			if (key == arr[midIdx]) {
				return 1;
			}
			if (key < arr[midIdx]) {
				lastIdx = midIdx - 1;
			} else {
				firstIdx = midIdx + 1;
			}
		}
		return 0;
	}
}
