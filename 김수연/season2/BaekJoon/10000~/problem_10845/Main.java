package problem_10845;

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
		
		ArrayList<Integer> que = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if (input.equals("push"))
				que.add(Integer.parseInt(st.nextToken()));
			else if (input.equals("pop")) {
				if (que.size() == 0)
					bw.write(-1 + "\n");
				else
					bw.write(que.remove(0) + "\n");
			} else if (input.equals("size"))
				bw.write(que.size() + "\n");
			else if (input.equals("empty")) {
				if (que.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			} else if (input.equals("front")) {
				if (que.size() == 0)
					bw.write(-1 + "\n");
				else
					bw.write(que.get(0) + "\n");
			} else if (input.equals("back")) {
				if (que.size() == 0)
					bw.write(-1 + "\n");
				else 
					bw.write(que.get(que.size() - 1) + "\n");
			}
		}
		
		
		br.close();
		bw.close();
	}
}