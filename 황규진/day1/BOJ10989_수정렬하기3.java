package day1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10989_수정렬하기3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		arr = quickSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	static int partition(int[] array, int start, int end) {
		int pivot = array[(start + end) / 2];
		while (start <= end) {
			while (array[start] < pivot)
				start++;
			while (array[end] > pivot)
				end--;
			if (start <= end) {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
				start++;
				end--;
			}
		}
		return start;
	}

	static int[] quickSort(int[] array, int start, int end) {
		int p = partition(array, start, end);
		if (start < p - 1)
			quickSort(array, start, p - 1);
		if (p < end)
			quickSort(array, p, end);
		return array;
	}

}
