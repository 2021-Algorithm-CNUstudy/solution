package subSet;

import java.util.Scanner;

public class Test {
	static int n = 4;
	static int totalcount;
	static boolean[] isSelected;
	static int[] input = {1, 2, 3, 4};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = 4;
		subSet(0);
		scan.close();
	}
	
	private static void subSet(int count) {
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0)
					System.out.print(input[j] + " ");
			}
			System.out.println();
		}
	}
}
