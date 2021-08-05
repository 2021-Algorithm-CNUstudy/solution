package problem_1926;

import java.util.Scanner;

public class Solution {

	public static boolean check(char num) {
		if (num == '3' || num == '6' || num == '9')
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();		// 10 <= n <= 1000
		scan.close();				// 1 2 - 4 5 - 7 8 - 10
									// 33 -> - - (x), -- (o)
		for (int i = 1; i <= n; i++) {
			String ii = Integer.toString(i);
			int count = 0;
			boolean loop = false;
			for (int j = 0; j < ii.length(); j++) {
				if (check(ii.charAt(j))) {
					count++;
					loop = true;
				}
			}
			
			if (loop) {		// 3, 6, 9가 포함되는 경우
				for (int j = 0; j < count; j++)
					System.out.print("-");
				System.out.print(" ");
			} else		// 3, 6, 9가 포함되지 않는 경우
				System.out.print(i + " ");
		}
		
	}
}
