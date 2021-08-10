package problem_1476;

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
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int answer = 1;
		int a = 1, b = 1, c = 1;
		while (! (e == a && s == b && m == c)) {
			a++;
			b++;
			c++;
			answer++;
			
			if (a == 16)
				a = 1;
			if (b == 29)
				b = 1;
			if (c == 20)
				c = 1;
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.close();
	}
}