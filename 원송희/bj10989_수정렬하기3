package practice

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); // 시간 초과 예방
		StringBuilder sb = new StringBuilder();
		String temp = br.readLine();
		int N = Integer.parseInt(temp);
		int [] howMany = new int[10000]; // 1 ~ 10000
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			howMany[num - 1]++; // 0은 카운트 안 하니까
		}
		for(int i = 0; i < 10000; i++) {
			while(howMany[i] != 0) { // 줄여 나가면서 인덱스를 출력
				sb.append(i + 1); // 0은 카운트 안 했으니까 인덱스 0 -> 숫자 1
				sb.append("\n"); 
				howMany[i]--; // 감소
			}
		}
		System.out.println(sb);
	}
}
