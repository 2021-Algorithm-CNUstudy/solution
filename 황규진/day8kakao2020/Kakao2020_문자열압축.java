package day8kakao2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Kakao2020_문자열압축 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] result = new int[s.length()];
		Arrays.fill(result, Integer.MAX_VALUE);
		for (int i = 2; i < s.length(); i++) {
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; i*j <= s.length(); j++) {
				if(i*(j+1) > s.length()) {
					String tmp = s.substring(i*j, s.length());
					if(map.containsKey(tmp)) {
						map.replace(tmp, map.get(tmp), map.get(tmp)+1);
					} else {
						map.put(tmp, 1);
					}
				} else {
					String tmp = s.substring(i*j, i*(j+1));
					if(map.containsKey(tmp)) {
						map.replace(tmp, map.get(tmp), map.get(tmp)+1);
					} else {
						map.put(tmp, 1);
					}
					
				}
			}
			System.out.println(map.keySet().toString());
			int count = i*map.keySet().size();
			Object[] valArr = map.values().toArray();
			for (int k = 0; k < valArr.length; k++) {
				if((int) valArr[k] != 1) {
					count++;
				}
			}
			result[i] = count;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < result.length; i++) {
			if(min > result[i]) {
				min = result[i];
			}
		}
		System.out.println(min);
		

	}

}
