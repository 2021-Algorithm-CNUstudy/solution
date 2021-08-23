package problem_1074;

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
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		// 사분면 판단
		while (n > 0) {
			int length = (int) Math.pow(2, n);
			
			if (r >= 0 && r < length / 2 && c >= length / 2 && c < length) {
				answer += Math.pow(4, n - 1);
				c -= length / 2;
			} else if (r >= length / 2 && r < length && c >= 0 && c < length / 2) {
				answer += (Math.pow(4, n - 1) * 2);
				r -= length / 2;
			} else if (r >= length / 2 && r < length && c >= length / 2 && c < length) {
				answer += (Math.pow(4, n - 1) * 3);
				r -= length / 2;
				c -= length / 2;
			}
			
			--n;
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.close();
	}
}