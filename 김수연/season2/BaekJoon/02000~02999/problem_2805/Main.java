package problem_2805;

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
		
		int[] list = new int[n];
		int right = -1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			list[i] = Integer.parseInt(st.nextToken());
			if (right < list[i]) right = list[i];
		}
		
		int left = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long answer = 0;
			for (int i = 0; i < n; ++i) {
				if (list[i] - mid > 0)
					answer += (list[i] - mid);
			}
			
			if (answer >= m)
				left = mid + 1;
			else
				right = mid - 1;
		}
		bw.write(right + "\n");
		
		br.close();
		bw.close();
	}
}