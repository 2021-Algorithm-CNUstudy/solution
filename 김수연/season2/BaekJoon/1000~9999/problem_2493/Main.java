package problem_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; ++i) {
			int input = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				stack.push(input);
				index.push(i);
				sb.append("0");
			} else {
				while (true) {
					if (! stack.isEmpty()) {
						int top = stack.peek();
						if (top > input) {
							sb.append(" " + index.peek());
							stack.push(input);
							index.push(i);
							break;
						} else {
							stack.pop();
							index.pop();
						}
					} else {
						sb.append(" 0");
						stack.push(input);
						index.push(i);
						break;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}