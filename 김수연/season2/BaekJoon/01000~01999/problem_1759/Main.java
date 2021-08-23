package problem_1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, c;
	static char[] input, output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		input = new char[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; ++i)
			input[i] = st.nextToken().charAt(0);
		
		output = new char[l];
		Arrays.sort(input);
		
		combination(0, 1);
		
		br.close();
		bw.close();
	}
	
	private static void combination(int count, int start) {
		if (count == l) {
			int answer1 = 0; // 모음
			int answer2 = 0; // 자음
			for (int i = 0; i < l; ++i) {
				if (output[i] == 'a' || output[i] == 'e' || output[i] == 'i' || output[i] == 'o' || output[i] == 'u')
					++answer1;
				else
					++answer2;
			}
			if (answer1 < 1) return;
			if (answer2 < 2) return;
			
			for (int i = 0; i < l; ++i)
				System.out.print(output[i]);
			System.out.println();
			return;
		}
		
		for (int i = start; i <= c; ++i) {
			output[count] = input[i - 1];
			combination(count + 1, i + 1);
		}
	}
}