package problem_2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			list[i] = Integer.parseInt(br.readLine());
			sum += list[i];
		}
		
		bw.write((int) Math.round((double) sum / n) + "\n");
		
		Arrays.sort(list);
		bw.write(list[n / 2] + "\n");
		
		boolean first = false;
		int max = 0;
		int answer = -1;
		
		for(int i = 0; i < n; i++) {
			int count = 1;
			int value = list[i];
			
			for(int j = i + 1; j < n; j++){
				if(value != list[j]) {
					i = j - 1;
					break;
				}
				count++;
			}
			
			if(count > max) {
				max = count;
				answer = value;
				first = true;
			} else if(count == max && first == true) {
				answer = value;
				first = false;
			}
			
		}
		bw.write(answer + "\n");
		
		bw.write(list[n - 1] - list[0] + "\n");
		
		br.close();
		bw.close();
	}
}