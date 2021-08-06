package problem_1225;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			scan.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for (int i = 0; i < 8; i++)
				list.add(i, scan.nextInt());
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				if (list.get(i) < min)
					min = list.get(i);
			}
			
			int offset = (min / 15) * 15;
			if (offset % 15 == 0)
				offset -= 15;
			
			for (int i = 0; i < 8; i++)
				list.set(i, list.get(i) - offset);
			
			int count = 1;
			int temp = list.remove(0);
			while (temp - count > 0) {
				list.add(temp - count);
				if (count == 5)
					count = 0;
				count++;
				temp = list.remove(0);
			}
			list.add(0);
			
			System.out.print("#" + test_case);
			for (int i = 0; i < list.size(); i++)
				System.out.print(" " + list.get(i));
			System.out.println();
		}
		scan.close();
	}
}
