package PandC;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	static boolean[] isSelected;
	static int[] numbers;
	static int n, totalCount;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("! 몇번 던질 것인가요: ");
		n = scan.nextInt();
		numbers = new int[n];
		System.out.println("1. 중복 순열\n2. 순열\n3. 중복 조합\n4. 조합");
		int input = scan.nextInt();

		switch (input) {
		case 1:
			// 1. 중복 순열
			multisetPermutation(0, 1);
			System.out.println("경우의 수: " + totalCount);
			break;
		case 2:
			// 2. 순열
			isSelected = new boolean[7];
			permutation(0, 1);
			System.out.println("경우의 수: " + totalCount);
			break;
		case 3:
			// 3. 중복 조합
			multisetCombination(0);
			System.out.println("경우의 수: " + totalCount);
			break;
		case 4:
			// 4. 조합
			combination(0);
			System.out.println("경우의 수: " + totalCount);
			break;
		}

		scan.close();
	}

	private static void multisetCombination(int count) {
		if (count == n) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			numbers[count] = i;
			multisetCombination(count + 1);
		}
	}

	private static void combination(int count) {
		if (count == n) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (isSelected[i])
				continue;

			numbers[count] = i;
			isSelected[i] = true;

			combination(count + 1);
			isSelected[i] = false;
		}
	}

	private static void multisetPermutation(int count, int start) {
		if (count == n) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[count] = i;
			multisetPermutation(count + 1, i);
		}
	}

	private static void permutation(int count, int start) {
		if (count == n) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[count] = i;
			permutation(count + 1, i + 1);
		}
	}
}
