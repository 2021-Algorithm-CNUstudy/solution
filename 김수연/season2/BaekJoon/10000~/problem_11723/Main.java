package problem_11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int bit = 0;
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("add")) {
				bit = add(bit, 20 - Integer.parseInt(st.nextToken()));
			} else if (input.equals("remove")) {
				bit = remove(bit, 20 - Integer.parseInt(st.nextToken()));
			} else if (input.equals("check")) {
				if (check(bit, 20 - Integer.parseInt(st.nextToken())))
					bw.write("1\n");
				else
					bw.write("0\n");
			} else if (input.equals("toggle")) {
				bit = toggle(bit, 20 - Integer.parseInt(st.nextToken()));
			} else if (input.equals("all")) {
				bit = all();
			} else if (input.equals("empty")) {
				bit = empty();
			}
		}
		
		br.close();
		bw.close();
	}
	
	private static int add(int bit, int num) {
		return bit | 1 << num;
	}
	
	private static int remove(int bit, int num) {
		return bit & ((1 << 20) - 1) - (1 << num);
	}
	
	private static boolean check(int bit, int num) {
		if ((bit & (1 << num)) == 1 << num)
			return true;
		return false;
	}
	
	private static int toggle(int bit, int num) {
		if ((bit & (1 << num)) == 0)
			return add(bit, num);
		else
			return remove(bit, num);
	}
	
	private static int all() {
		return (1 << 20) - 1;
	}
	
	private static int empty() {
		return 0;
	}
}