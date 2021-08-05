package problem_1228;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = 10;
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = scan.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) 
				list.add(scan.nextInt());
			
			n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				scan.next();
				int index = scan.nextInt();
				int num = scan.nextInt();
				for (int j = 0; j < num; j++)
					list.add(index++, scan.nextInt());
			}
			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++)
				System.out.print(" " + list.get(i));
			System.out.println();
		}
		scan.close();
	}
}
