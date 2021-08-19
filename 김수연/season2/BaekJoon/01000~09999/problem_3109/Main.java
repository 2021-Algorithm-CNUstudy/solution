package problem_3109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r, c, count;
	static char[][] arr;
	static int[] di = {-1, 0, 1};
	static int dj = -1;
	static boolean find;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[r][c];
		arr = new char[r][c];
		for (int i = 0; i < r; ++i)
			arr[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < r; ++i) {
			find = false;
			pipe(i, c - 1);
		}
		
		bw.write(count + "\n");
		br.close();
		bw.close();
	}
	
	private static void pipe(int i, int j) {
		if (j == 0) {
			find = true;
			++count;
			return;
		}
		
		for (int dir = 0; dir < 3 && ! find; ++dir) {
			int newI = i + di[dir];
			int newJ = j + dj;
			
			if (newI < 0 || newI >= r || newJ < 0 || newJ >= c) continue;
			if (! isVisited[newI][newJ] && arr[newI][newJ] == '.') {
				isVisited[newI][newJ] = true;
				pipe(newI, newJ);
			}
		}
	}
}