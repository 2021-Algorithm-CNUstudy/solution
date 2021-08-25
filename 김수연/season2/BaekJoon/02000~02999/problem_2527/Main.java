package problem_2527;

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
		
		for (int test_case = 0; test_case < 4; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			if ((x1 == x4 && y2 == y3) || (x1 == x4 && y1 == y4) || (x2 == x3 && y1 == y4) || (x2 == x3 && y2 == y3))
				bw.write("c\n");
			else if ((x1 == x4 && y2 != y3) || (x1 != x4 && y1 == y4) || (x2 == x3 && y1 != y4) || (x2 != x3 && y2 == y3))
				bw.write("b\n");
			else if (x1 > x4 || y1 > y4 || x2 < x3 || y2 < y3)
				bw.write("d\n");
			else
				bw.write("a\n");
		}
		
		br.close();
		bw.close();
	}
}