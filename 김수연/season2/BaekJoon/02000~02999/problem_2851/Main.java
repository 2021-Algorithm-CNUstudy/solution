package problem_2851;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int score = 0;
		for (int i = 0; i < 10; ++i) {
			int input = Integer.parseInt(br.readLine());
			if (score + input <= 100) {
				score += input;
			} else if (score + input > 100) {
				int difference1 = 100 - score;
				int difference2 = score + input - 100;
				
				if (difference1 >= difference2)
					score += input;
				break;
			}
		}
		
		bw.write(score + "\n");
		
		br.close();
		bw.close();
	}
}