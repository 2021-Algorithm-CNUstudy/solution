package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2751_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		str = br.readLine();
		st = new StringTokenizer(str);
		int[] arr2 = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < arr2.length; i++) {
			boolean check = false;
			for (int j = 0; j < arr.length; j++) {
				if(arr2[i] == arr[j]) {
					System.out.println("1");
					check = true;
					break;
				}
			}
			if(!check)
				System.out.println("0");
		}
	}

}
