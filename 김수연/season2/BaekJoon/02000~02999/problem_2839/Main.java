package problem_2839;

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
		
		int five = n / 5;
		int three = (n - five * 5) / 3;
		
		while (five * 5 + three * 3 != n) {
			if (five < 0 || three < 0)
				break;
			--five;
			three = (n - five * 5) / 3;
		}
		
		if (five < 0)
			three = 0;
		bw.write((String.valueOf(five + three)));
		
		br.close();
		bw.close();
	}
}