package practice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		String [] split = s.split("-");
		int length = split.length;
		int answer = 0;
		if(split[0].contains("+")) {
			String [] temp = split[0].split("\\+");
			for(int i = 0; i < temp.length; i++) {
				answer += Integer.parseInt(temp[i]);
			}
		}
		else {
			answer += Integer.parseInt(split[0]);
		}
		for(int i = 1; i < length; i++) {
			if(split[i].contains("+")) {
				String [] temp = split[i].split("\\+");
				for(int j = 0; j < temp.length; j++) {
					answer -= Integer.parseInt(temp[j]);
				}
			}
			else {
				answer -= Integer.parseInt(split[i]);
			}
		}
		System.out.println(answer);
	}
}
