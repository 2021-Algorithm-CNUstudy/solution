package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if(input.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				
			} else if(input.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				
			} else if(input.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				
			} else if(input.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				
			} else if(input.equals("all")) {
				
			} else if(input.equals("empty")) {
				
			}
		}
		
	}

}
