package permutationAndCombination;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	static boolean[] isSelected;
	static int[] output;
	static int r, n, totalCount;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("! 몇번 던질 것인가요: ");
		r = scan.nextInt();
		n = 6;
		output = new int[r];
		System.out.println("1. 중복 순열\n2. 순열\n3. 중복 조합\n4. 조합");
		int input = scan.nextInt();

		switch (input) {
		case 1:
			// 1. 중복 조합
			multisetCombination(0, 1);
			System.out.println("경우의 수: " + totalCount);
			break;
		case 2:
			// 2. 조합
			isSelected = new boolean[7];
			combination(0, 1);
			System.out.println("경우의 수: " + totalCount);
			break;
		case 3:
			// 3. 중복 순열
			multisetPermutation(0);
			System.out.println("경우의 수: " + totalCount);
			break;
		case 4:
			// 4. 순열
			isSelected = new boolean[7];
			permutation(0);
			System.out.println("경우의 수: " + totalCount);
			permutation2(0, 0);
			System.out.println("경우의 수: " + totalCount);
			break;
		}

		scan.close();
	}

	private static void multisetPermutation(int count) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			output[count] = i;
			multisetPermutation(count + 1);
		}
	}

	private static void permutation(int count) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (isSelected[i])
				continue;

			output[count] = i;
			isSelected[i] = true;

			permutation(count + 1);
			isSelected[i] = false;
		}
	}

	private static void permutation2(int count, int flag) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0) continue;

			output[count] = i;
			permutation2(count + 1, flag | 1 << i);
		}
	}

	private static void multisetCombination(int count, int start) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = start; i <= 6; i++) {
			output[count] = i;
			multisetCombination(count + 1, i);
		}
	}

	private static void combination(int count, int start) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = start; i <= 6; i++) {
			if (isSelected[i])
				continue;
			output[count] = i;
			isSelected[i] = true;
			
			combination(count + 1, i + 1);
			isSelected[i] = false;
		}
	}
}
