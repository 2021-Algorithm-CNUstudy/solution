package problem_3052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] list = new boolean[42];
		int count = 0;
		
		for (int i = 0; i < 10; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (list[temp % 42]) continue;
			list[temp % 42] = true;
			++count;
		}
		
		bw.write(count + "");

		br.close();
		bw.close();
	}
}