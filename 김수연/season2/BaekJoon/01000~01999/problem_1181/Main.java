package problem_1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] list = new String[n];
		for (int i = 0; i < n; ++i)
			list[i] = br.readLine();
		
		Arrays.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					for (int i = 0; i < o1.length(); ++i) {
						if (o1.charAt(i) == o2.charAt(i))
							continue;
						return o1.charAt(i) - o2.charAt(i);
					}
				}
				return o1.length() - o2.length();
			}
			
		});
		String before = "";
		for (int i = 0; i < n; ++i) {
			if (before.equals(list[i])) {
				
			} else {
				bw.write(list[i] + "\n");
			}
			before = list[i];
		}
		
		br.close();
		bw.close();
	}
}