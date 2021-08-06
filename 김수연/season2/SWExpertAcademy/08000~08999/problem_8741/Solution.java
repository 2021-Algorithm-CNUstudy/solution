package problem_8741;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			bw.write("#" + test_case + " ");
			for (int i = 0; i < 3; i++) {
				char output = st.nextToken().charAt(0);
				char outputBig = (char) (output - 32);
				bw.write(outputBig);
			}
				
			bw.write("\n");
		}
		bw.close();
	}
}