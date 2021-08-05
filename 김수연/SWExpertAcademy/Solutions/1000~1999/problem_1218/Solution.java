package problem_1218;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = 10;
		for (int test_case = 1; test_case <= t; ++test_case) {
			int n = scan.nextInt();
			String input = scan.next();
			
			Stack<Character> st = new Stack<Character>();
			for (int index = 0; index < n; ++index) {
				if (st.size() == 0)						// size == 0
					st.push(input.charAt(index));
				else {									// size > 0
					char before = st.peek();
					st.push(input.charAt(index));
					char after = st.peek();
					
					if ((before == '(' && after == ')') || 
							(before == '{' && after == '}') || 
							(before == '[' && after == ']') || 
							(before == '<' && after == '>')) {
						st.pop();
						st.pop();
					}
				}
			}
			System.out.println("#" + test_case + " " + (st.isEmpty() ? 1 : 0));
		}
		scan.close();
	}
}