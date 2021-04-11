package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ5525_IOI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		String P = "I";
		for (int i = 0; i < N; i++) {
			P += "OI";
		}
		int count = 0;
//		while(S.contains(P)) {
//			String tmp = P.substring(0, P.length()-2);
//			S = S.replaceFirst(P, tmp);
//			count++;
//		}
		Pattern pattern = Pattern.compile(P);
		Matcher matcher = pattern.matcher(S);
		System.out.println(matcher.groupCount());
//		System.out.println(count);
	}

}
