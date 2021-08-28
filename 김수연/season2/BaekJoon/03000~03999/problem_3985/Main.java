package problem_3985;

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
		
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[l];
		int maxNum = -1;
		int maxPiece = 0;
		for (int num = 1; num <= n; ++num) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			int k = Integer.parseInt(st.nextToken()) - 1;
			
			if (k - p + 1 > maxPiece) {
				maxPiece = k - p + 1;
				maxNum = num;
			}
			
			for (int index = p; index <= k; ++index) {
				if (list[index] != 0) continue;
				list[index] = num;
			}
		}
		
		bw.write(maxNum + "\n");
		
		int[] check = new int[n];
		for (int i = 0; i < l; ++i) {
			if (list[i] == 0) continue;
			++check[list[i] - 1];
		}
		
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < n; ++i) {
			if (check[i] > max) {
				max = check[i];
				maxIndex = i + 1;
			}
		}
		bw.write(maxIndex + "\n");
		
		br.close();
		bw.close();
	}
}