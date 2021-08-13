package permutation;

import java.util.Arrays;

public class Test {
	static int n, r, totalCount;
	static int[] input, output;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		input = new int[] {1, 2, 7, 9};
		n = input.length;
		r = 2;
		output = new int[r];
		
		permutation(0, 0);
		System.out.println(Arrays.toString(input));
		System.out.println("n: " + n + " r: " + r);
		System.out.println("nPr: " + totalCount + "개");
		
		totalCount = 0;
		isSelected = new boolean[n];
		permutation(0);
		System.out.println(Arrays.toString(input));
		System.out.println("n: " + n + " r: " + r);
		System.out.println("nPr: " + totalCount + "개");
	}

	private static void permutation(int count, int flag) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0) continue;

			output[count] = input[i];
			permutation(count + 1, flag | 1 << i);
		}
	}
	
	private static void permutation(int count) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isSelected[i]) continue;
			output[count] = input[i];
			isSelected[i] = true;
			permutation(count + 1);
			isSelected[i] = false;
		}
	}
}
