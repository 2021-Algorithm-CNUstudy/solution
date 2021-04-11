package day8kakao2020;

import java.util.Scanner;


public class Kakao2020_괄호변환 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String p = sc.next();
		String answer = "";
		if(p.equals("")) {
			answer = "";
			//return answer;
		}
		System.out.println(div(p));
		
	}
	public static String div(String arr) {
		if(arr.length() == 0) {
			return "";
		}
		int a = 0;
		int b = 0;
		for (int i = 0; i < arr.length(); i++) {
			if(arr.charAt(i) == '(') {
				a++;				
			}
			else if(arr.charAt(i) == ')') {
				b++;
			}
			if(a != 0 && b != 0 && a == b) {
				String u = arr.substring(0, a+b);
				String v = arr.substring(a+b, arr.length());
				if(u.charAt(0) == ')') {
					String tmp = "";
					tmp += '(';
					tmp += div(v);
					tmp += ')';
					u = u.substring(1, u.length()-1);
					char[] tmparr = u.toCharArray();
					for (int j = 0; j < tmparr.length; j++) {
						if(tmparr[j] == '(')
							tmparr[j] = ')';
						else
							tmparr[j] = '(';
					}
					String sum = "";
					for (int j = 0; j < tmparr.length; j++) {
						sum += tmparr[j];
					}
					tmp += sum;
					return tmp;
				} else {
					return u + div(v);
				}
			}
		}
		return "";
	}
}
