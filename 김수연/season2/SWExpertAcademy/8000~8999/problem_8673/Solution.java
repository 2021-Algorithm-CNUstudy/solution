package problem_8673;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int k = scan.nextInt();
			int n = (int) Math.pow(2, k);
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				list.add(scan.nextInt());
			
			int index = 0;
			int answer = 0;
			while (list.size() != 1) {
				int item1 = list.get(index);
				int item2 = list.get(index + 1);
				
				if (item1 > item2) {
					list.remove(index + 1);
					answer += (item1 - item2);
				} else {
					list.remove(index);
					answer += (item2 - item1);
				}
				
				index++;
				if (index > list.size() - 1)
					index = 0;
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		scan.close();
	}
}
