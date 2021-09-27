package problem_1620;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for (int i = 1; i <= n; ++i) {
			String input = br.readLine();
			map.put(Integer.toString(i), input);
			map.put(input, Integer.toString(i));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; ++i)
			sb.append(map.get(br.readLine()) + "\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}