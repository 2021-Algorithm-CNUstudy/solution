package problem_2941;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int count = 0;
		int length = input.length();
		for (int i = 0; i < length; ++i) {
			char temp = input.charAt(i);
			
			if (i + 2 < length) {
				char temp2 = input.charAt(i + 1);
				char temp3 = input.charAt(i + 2);
				if (temp == 'd' && temp2 == 'z' && temp3 == '=') {
					++count;
					i += 2;
					continue;
				}
			} 
			
			if (i + 1 < length) {
				char temp2 = input.charAt(i + 1);
				if (temp == 'c' && (temp2 == '=' || temp2 == '-')) {
					++count;
					++i;
					continue;
				} else if (temp == 'd' && temp2 == '-') {
					++count;
					++i;
					continue;
				} else if ((temp == 'n' || temp == 'l') && temp2 == 'j') {
					++count;
					++i;
					continue;
				} else if ((temp == 's' || temp == 'z') && temp2 == '=') {
					++count;
					++i;
					continue;
				}
			}
			++count;
		}
		bw.write(count + "\n");
		
		br.close();
		bw.close();
	}
}