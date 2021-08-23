package problem_2609;

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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		int answer = 1;
		for (int i = 1; i <= min; ++i) {
			if (min % i == 0 && max % i == 0) {
				answer = i;
			}
		}
		bw.write(answer + "\n");
		
		for (int i = min; ; i += min) {
			if (i % max == 0) {
				answer = i;
				break;
			}
		}
		bw.write(answer + "\n");
		br.close();
		bw.close();
	}
}