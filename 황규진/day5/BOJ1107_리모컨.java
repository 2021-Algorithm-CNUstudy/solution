package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1107_리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int N = Integer.parseInt(br.readLine());
		String N = br.readLine();
		int M = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				list.add(st.nextToken());
			}			
		}
		if(M == 10) {
			System.out.println(Integer.parseInt(N)-100);
			return;
		}
		int submin = Math.abs(Integer.parseInt(N)-100);
		int num = 100;
		int result = 0;
		// int length = (int)(Math.log10(N)+1);
		int length = N.length();
		if(Integer.parseInt(N) >=97 && Integer.parseInt(N) <= 103) {
			System.out.println(Math.abs(Integer.parseInt(N)-100));
			return;
		}
		if(N.length() == 1) {
			if(!list.contains(N)) {
				System.out.println(1);
				return;
			} else {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < 10; i++) {
					if(!list.contains(Integer.toString(i))) {
						int tmp = Math.abs(Integer.parseInt(N) - i);
						if(tmp < min) {
							min = tmp;
						}
					}
				}
				System.out.println(1+min);
				return;
			}
		}
		
		for (int i = (int) Math.pow(10, length - 1); i < Math.pow(10, length + 1); i++) {
			boolean check = false;
			for (int j = 0; j < length; j++) {
				if (list.contains(Character.toString(Integer.toString(i).charAt(j)))) {
					check = true;
				}
			}
			if (!check) {
				int sub = Math.abs(Integer.parseInt(N) - i);
				if (submin > sub) {
					submin = sub;
					num = i;
				}
			}
		}
//		System.out.println(num);
//		System.out.println(result);
//		System.out.println(submin);
		 
		result = (int) (Math.log10(num) + 1) + submin;			
		System.out.println(result);

	}

}
