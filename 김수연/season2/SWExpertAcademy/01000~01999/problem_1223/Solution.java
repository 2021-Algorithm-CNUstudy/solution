package problem_1223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int test_case = 1; test_case <= 10; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; ++i) {
				char temp = input.charAt(i);
				if (temp >= '0' && temp <= '9')
					sb.append(temp);
				else {
					if (stack.size() == 0)
						stack.push(temp);
					else {
						if (temp == '*' && stack.peek() == '+')
							stack.push(temp);
						else if (temp == '*' && stack.peek() == '*') {
							sb.append(temp);
						}
						else if (temp == '+' && stack.peek() == '*') {
							while (stack.size() != 0)
								sb.append(stack.pop());
							stack.push(temp);
						} else if (temp == '+' && stack.peek() == '+')
							sb.append(temp);
					}
				}
			}
			while (stack.size() != 0)
				sb.append(stack.pop());
			
			input = sb.toString();
			
			Stack<Integer> cal = new Stack<>();
			for (int i = 0; i < n; ++i) {
				char temp = input.charAt(i);
				if (temp >= '0' && temp <= '9')
					cal.push(temp - '0');
				else {
					if (temp == '+')
						cal.push(cal.pop() + cal.pop());
					else if (temp == '*')
						cal.push(cal.pop() * cal.pop());
				}
			}
			
			bw.write("#" + test_case + " " + cal.pop() + "\n");
		}
		br.close();
		bw.close();
	}
}