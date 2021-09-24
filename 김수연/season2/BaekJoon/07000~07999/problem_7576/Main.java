package problem_7576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int zero = 0;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				int input = Integer.parseInt(st.nextToken());
				arr[i][j] = input;
				
				if (input == 0)
					++zero;
			}
		}
		
		int answer = 0;
		
		if (zero == 0)
			bw.write(answer + "\n");
		else {
			int[] di = {1, -1, 0, 0};
			int[] dj = {0, 0, 1, -1};
			
			Queue<Pos> list = new LinkedList<>();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (arr[i][j] == 1)
						list.offer(new Pos(i, j, 0));
				}
			}
			
			while (! list.isEmpty()) {
				Pos np = list.poll();
				answer = np.date;
				
				for (int dir = 0; dir < 4; ++dir) {
					int ni = np.i + di[dir];
					int nj = np.j + dj[dir];
					
					if (ni < 0 || ni >= n || nj < 0 || nj >= m)
						continue;
					
					if (arr[ni][nj] == 1 || arr[ni][nj] == -1)
						continue;
					
					list.offer(new Pos(ni, nj, np.date + 1));
					arr[ni][nj] = 1;
					--zero;
				}
			}
			
			if (zero > 0)
				bw.write("-1\n");
			else
				bw.write(answer + "\n");
		}
		
		br.close();
		bw.close();
	}
}

class Pos {
	int i, j, date;
	
	Pos(int i, int j, int date) {
		this.i = i;
		this.j = j;
		this.date = date;
	}
}