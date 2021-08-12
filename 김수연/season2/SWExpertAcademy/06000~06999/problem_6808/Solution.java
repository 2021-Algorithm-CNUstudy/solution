package problem_6808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n = 9, win, lose;
	static int[] gyu, in, temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			gyu = new int[9];
			in = new int[9];
			temp = new int[9];
			
			for (int i = 0; i < 9; ++i)
				temp[i] = Integer.parseInt(st.nextToken());
			
			gyu = temp.clone();
			
			Arrays.sort(temp);
			
			int num = 1;
			int index = 0;
			for (int i = 0; i < 9; ++i) {
				while (index < 9 && temp[index] == num) {
					++index;
					++num;
				}
				in[i] = num++;
			}
				
			temp = new int[9];
			permutation(0, 0);
			
			bw.write("#" + test_case + " " + win + " " + lose + "\n");
		}
		br.close();
		bw.close();
	}
	
	private static void permutation(int count, int flag) {
		if (count == n) {
			game();
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0) continue;

			temp[count] = in[i];
			permutation(count + 1, flag | 1 << i);
		}
	}
	
	private static void game() {
		int inScore = 0;
		int gyuScore = 0;
		
		for (int i = 0; i < 9; ++i) {
			if (gyu[i] < temp[i])
				inScore += (gyu[i] + temp[i]);
			else if (temp[i] < gyu[i])
				gyuScore += (gyu[i] + temp[i]);
		}
		
		if (inScore > gyuScore)
			++lose;
		else if (gyuScore > inScore)
			++win;
	}
}