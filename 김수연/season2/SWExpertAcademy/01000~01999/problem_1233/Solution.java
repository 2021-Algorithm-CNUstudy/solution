package problem_1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int test_case = 1; test_case <= 10; ++test_case) {
			int n = Integer.parseInt(br.readLine());
			
			int answer = 1;
			
			for (int i = 1; i <= n; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); // 정점 번호
				
				String temp = st.nextToken();
				
				// 자식 노드가 있어야 하는 정점
				if (i <= n / 2) {
					if ((temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")))
						answer = 1;
					else
						answer = 0;
					
				}
				
				// 자식 노드가 없어야 하는 정점
				else {
					if ((temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")))
						answer = 0;
				}
			}
			
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}
}