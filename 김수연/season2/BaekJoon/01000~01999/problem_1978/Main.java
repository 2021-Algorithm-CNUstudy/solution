package problem_1978;

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
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			list[i] = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[1001];
		check[0] = true;
		check[1] = true;
		
		for (int i = 4; i < 1001; i += 2)
			check[i] = true;
		for (int i = 3; i < 1001; i += 2) {
			if (check[i]) continue;
			int plus = i;
			while (i + plus < 1001) {
				check[i + plus] = true;
				plus += i;
			}
		}
		
		int answer = 0;
		for (int i = 0; i < n; ++i) {
			if (! check[list[i]])
				++answer;
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.close();
	}
}