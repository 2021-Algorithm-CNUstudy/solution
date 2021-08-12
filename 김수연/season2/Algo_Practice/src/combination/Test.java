package combination;

import java.util.Arrays;

public class Test {
	static int[] input, output;
	static int n, r, totalCount;

	public static void main(String[] args) {
		input = new int[] {1, 3, 7, 9};
		n = input.length;
		r = 2;
		output = new int[r];
		
		combination(0, 1);
		
		System.out.println();
		System.out.println(Arrays.toString(input));
		System.out.println("n: " + n + " r: " + r);
		System.out.println("nCr: " + totalCount + "개");
	}

	private static void combination(int count, int start) {
		if (count == r) {
			totalCount++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = start; i <= n; i++) {
			output[count] = input[i - 1];
			combination(count + 1, i + 1);
		}
	}
}