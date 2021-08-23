package problem_2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		for (int i = 0; i < n; ++i)
			list[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(list);		
		
		for (int i = 0; i < n; ++i)
			bw.write(list[i] + "\n");
		
		br.close();
		bw.close();
	}
}