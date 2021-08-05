package problem_10570;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int count = 0;
			
			loop: for (int num = a; num <= b; num++) {
				Double sqrtNum = Math.sqrt(num);
				
				if (sqrtNum != sqrtNum.intValue())
					continue loop;
				
				String numS = Integer.toString(num);
				String sqrtNumS = Integer.toString(sqrtNum.intValue());
				
				for (int i = 0; i < numS.length() / 2; i++) {
					if (numS.charAt(i) != numS.charAt(numS.length() - 1 - i))
						continue loop;
				}
				
				for (int i = 0; i < sqrtNumS.length() / 2; i++) {
					if (sqrtNumS.charAt(i) != sqrtNumS.charAt(sqrtNumS.length() - 1 - i))
						continue loop;
				}
				count++;
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		scan.close();
	}
}
