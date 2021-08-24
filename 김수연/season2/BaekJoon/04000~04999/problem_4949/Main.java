package problem_4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String input = br.readLine();
		while (! input.equals(".")) {
			Stack<Character> stack = new Stack<>();
			boolean check = true;
			for (int i = 0; i < input.length(); ++i) {
				char inputChar = input.charAt(i);
				if (inputChar == '(')
					stack.push('(');
				else if (inputChar == '[')
					stack.push('[');
				else if (inputChar == ')') {
					if (stack.size() == 0) {
						check = false;
						break;
					} else {
						if (stack.peek() == '(')
							stack.pop();
						else {
							check = false;
							break;
						}
					}
				} else if (inputChar == ']') {
					if (stack.size() == 0) {
						check = false;
						break;
					} else {
						if (stack.peek() == '[')
							stack.pop();
						else {
							check = false;
							break;
						}
					}
				}
			}
			if (stack.size() != 0) check = false;
			
			if (check)
				bw.write("yes\n");
			else
				bw.write("no\n");
			
			input = br.readLine();
		}
		
		br.close();
		bw.close();
	}
}