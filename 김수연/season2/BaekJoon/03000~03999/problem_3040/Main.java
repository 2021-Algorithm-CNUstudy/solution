package problem_3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] input, output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[9];
		for (int i = 0; i < 9; ++i)
			input[i] = Integer.parseInt(br.readLine());
		
		output = new int[7];
		combination(0, 1);
		
		br.close();
	}

	private static void combination(int count, int start) {
		if (count == 7) {
			int sum = 0;
			for (int i = 0; i < 7; ++i)
				sum += input[output[i]];
			if (sum == 100) {
				for (int i = 0; i < 7; ++i)
					System.out.println(input[output[i]]);
			}
			return;
		}

		for (int i = start; i <= 9; i++) {
			output[count] = i - 1;
			combination(count + 1, i + 1);
		}
	}
}