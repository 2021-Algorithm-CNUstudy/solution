package problem_1946;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = scan.nextInt();
			
			int size = 0;
			String answer = "";
			
			for (int i = 0; i < n; i++) {
				String ch = scan.next();
				int number = Integer.parseInt(scan.nextLine().trim());
				size += number;
				
				for (int j = 0; j < number; j++)
					answer += ch;
				
				
			}
			System.out.println("#" + test_case);
			
			for (int j = 0; j < size; j++) {
				System.out.print(answer.charAt(j));
				if (j % 10 == 9 && j != size-1)
					System.out.println();
			}
			System.out.println();
		}
		
		scan.close();
	}
}
