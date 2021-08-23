package problem_10866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<String> list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if (input.equals("push_front"))
				list.add(0, st.nextToken());
			else if (input.equals("push_back"))
				list.add(st.nextToken());
			else if (input.equals("pop_front")) {
				if (list.size() == 0) bw.write(-1 + "\n");
				else bw.write(list.remove(0) + "\n");
			} else if (input.equals("pop_back")) {
				if (list.size() == 0) bw.write(-1 + "\n");
				else bw.write(list.remove(list.size() - 1) + "\n");
			} else if (input.equals("size"))
				bw.write(list.size() + "\n");
			else if (input.equals("empty")) {
				if (list.isEmpty()) bw.write(1 + "\n");
				else bw.write(0 + "\n");
			} else if (input.equals("front")) {
				if (list.isEmpty()) bw.write(-1 + "\n");
				else bw.write(list.get(0) + "\n");
			} else if (input.equals("back"))
				if (list.isEmpty()) bw.write(-1 + "\n");
				else bw.write(list.get(list.size() - 1) + "\n");
		}
		
		br.close();
		bw.close();
	}
}