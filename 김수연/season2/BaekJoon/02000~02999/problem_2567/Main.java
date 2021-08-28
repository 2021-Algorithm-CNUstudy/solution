package problem_2567;

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
		
		boolean[][] arr = new boolean[101][101];
		int n = Integer.parseInt(br.readLine());
		for (int count = 0; count < n; ++count) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int i = a; i < a + 10; ++i) {
				for (int j = b; j < b + 10; ++j) {
					arr[i][j] = true;
				}
			}
		}
		
		int answer = 0;
		int[] di = {1, -1, 0, 0};
		int[] dj = {0, 0, 1, -1};
		
		for (int i = 0; i <= 100; ++i) {
			for (int j = 0; j <= 100; ++j) {
				if (! arr[i][j]) continue;
				
				for (int dir = 0; dir < 4; ++dir) {
					int ni = i + di[dir];
					int nj = j + dj[dir];
					
					if (ni < 0 || ni > 100 || nj < 0 || nj > 100) continue;
					if (! arr[ni][nj]) ++answer;
				}
			}
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.close();
	}
}