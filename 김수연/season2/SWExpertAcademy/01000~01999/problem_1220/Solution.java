package problem_1220;

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
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;	// 교착 상태 체크
			boolean check = false;
			
			for (int i = 0; i < n; i++) {			// 세로 한 줄씩 순회
				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 1) {			// N극 -> 아래로 내려감
						check = true;
						continue;
					} else if (arr[j][i] == 2 && check) {
						check = false;
						answer++;
					}
				}
				check = false;
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		br.close();
		bw.close();
	}
}
