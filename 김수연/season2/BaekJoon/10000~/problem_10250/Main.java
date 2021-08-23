package problem_10250;

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
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int xx = n / h + 1;
			int yy = n % h;
			if (yy == 0) {
				yy = h;
				--xx;
			}
			
			bw.write(yy * 100 + xx + "\n");
		}
		
		br.close();
		bw.close();
	}
}