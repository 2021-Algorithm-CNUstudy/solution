package problem_1874;

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
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (stack.size() == 0) {
				stack.push(num++);
				sb.append("+\n");
			}
			
			if (stack.peek() < temp) {
				while (stack.peek() != temp) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else if (stack.peek() == temp) {
				stack.pop();
				sb.append("-\n");
			} else {
				sb = new StringBuilder("NO\n");
				break;
			}
		}
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}