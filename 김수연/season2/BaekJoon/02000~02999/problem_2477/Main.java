package problem_2477;

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
		
		int k = Integer.parseInt(br.readLine());
		
		int[] lengths = new int[6];
		int maxI = -1, maxJ = -1;
		boolean jj = false;
		for (int index = 0; index < 6; ++index) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			lengths[index] = length;
			if (dir == 1 || dir == 2) {
				if (maxJ < length)
					maxJ = length;
			}
			else if (dir == 3 || dir == 4) {
				if (maxI < length)
					maxI = length;
			}
			
			if (dir == 1 || dir == 2) jj = true;
			else jj = false;
		}
		jj = ! jj;
		
		int minI = 10000, minJ = 10000;
		for (int i = 0; i < 6; ++i) {
			int len = lengths[(i + 5) % 6] + lengths[(i + 1) % 6];
			if (! jj & len == maxJ)
				minI = lengths[i];
			else if (jj && len == maxI)
				minJ = lengths[i];
			jj = ! jj;
		}
		
		bw.write((maxI * maxJ - minI * minJ) * k + "\n");
		
		br.close();
		bw.close();
	}
}