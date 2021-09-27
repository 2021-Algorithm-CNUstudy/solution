package problem_1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int two = 0;
		int five = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		while (n >= 1) {
			int temp = n;
			
			while (temp % 2 == 0) {
				temp /= 2;
				++two;
			}
			
			while (temp % 5 == 0) {
				temp /= 5;
				++five;
			}
			
			--n;
		}
		
		bw.write(Math.min(two, five) + "\n");
		
		br.close();
		bw.close();
	}
}