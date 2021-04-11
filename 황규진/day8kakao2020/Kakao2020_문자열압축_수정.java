package day8kakao2020;

import java.util.Arrays;
import java.util.Scanner;

public class Kakao2020_문자열압축_수정 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if(s.length() == 1) {
			System.out.println(1);
			return;
		}
		int[] answer = new int[s.length()];
		Arrays.fill(answer, Integer.MAX_VALUE);
		for (int i = 1; i < s.length(); i++) {
			String result = s.substring(0, i);
			for (int j = 1; j < s.length()/i+1; j++) {
				String tmp;
				if(i*(j+1) > s.length()) {
					tmp = s.substring(i*j, s.length());
				} else {
					tmp = s.substring(i*j, i*(j+1));
				}
				if(tmp.equals("")) {
					continue;
				}
				if(result.substring(result.length()-i, result.length()).equals(tmp)) {
					if(result.length()-i-1 >= 0 && result.substring(result.length()-i-1, result.length()-i).equals("1")) {
						continue;
					} else {
						result = result.substring(0, result.length()-i) + "1"+tmp;
					}
				} else {
					result += tmp;
				}
			}
			answer[i] = result.length();
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < answer.length; i++) {
			if(min > answer[i])
				min = answer[i];
		}
		System.out.println(min);

	}

}
