package problem_1234;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			int length = Integer.parseInt(scan.next());
			String temp = scan.next();
			
			ArrayList<Character> list = new ArrayList<Character>();
			for (int i = 0; i < length; i++)
				list.add(temp.charAt(i));
			
			while (remove(list)) {}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < list.size(); ++i)
				System.out.print(list.get(i));
			System.out.println();
		}
		scan.close();
	}
	
	private static boolean remove(ArrayList<Character> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == list.get(i + 1)) {
				list.remove(i);
				list.remove(i);
				return true;
			}
		}
		return false;
	}
}
