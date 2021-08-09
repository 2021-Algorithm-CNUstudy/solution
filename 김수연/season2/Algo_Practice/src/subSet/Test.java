package subSet;

import java.util.Scanner;

public class Test {
	static int n;
	static int totalcount;
	static boolean[] isSelected;
	static int[] input = {1, 2, 3, 4};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		n = 4;
//		isSelected = new boolean[n];
//		subSet(0);
//		System.out.println(totalcount);
		scan.close();
	}
	
	private static void subSet(int count) {
		if (count == n) {
			totalcount++;
			for (int i = 0; i < n; i++)
				System.out.print((isSelected[i] ? input[i] : "X") + " ");
			System.out.println();
			return ;
		} else {
			isSelected[count] = true;
			subSet(count + 1);
			isSelected[count] = false;
			subSet(count + 1);
		}
	}
}
