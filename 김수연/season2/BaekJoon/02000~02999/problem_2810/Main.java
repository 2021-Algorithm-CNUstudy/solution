package problem_2810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		int sCount = 0;
		int lCount = 0;
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) == 'S')
				++sCount;
			else if (input.charAt(i) == 'L') {
				++lCount;
				++i;
			}
		}
		
		int answer = 0;
		if (n == sCount)
			answer = n;
		else
			answer = sCount + lCount + 1;
		
		bw.write(answer + "\n");
		br.close();
		bw.close();
	}
}