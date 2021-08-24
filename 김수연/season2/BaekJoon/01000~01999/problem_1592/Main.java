package problem_1592;

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
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] list = new int[n];
		int index = 0;
		int answer = 0;
		++list[index];
		while (list[index] != m) {
			if (list[index] % 2 == 1) {
				index += l;
				if (index >= n)
					index -= n;
			} else {
				index -= l;
				if (index < 0)
					index += n;
			}
			++list[index];
			++answer;
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.close();
	}
}