package problem_19236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dj = {0, -1, -1, -1, 0, 1, 1, 1};
		
		int[][] arr = new int[4][4];
		Fish[] fishes = new Fish[16];
		
		for (int i = 0; i < 4; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; ++j) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				arr[i][j] = num;
				fishes[i * 4 + j] = new Fish(num, dir, i, j);
			}
		}
		
		Fish shark = new Fish(-1, -1, -1, -1);
		
		// 1. 물고기 이동
		
		
		// 2. 상어 이동(dfs)
		
		
		br.close();
		bw.close();
	}
}

class Fish {
	int num, dir, i, j;
	boolean alive;
	
	Fish (int num, int dir, int i, int j) {
		this.num = num;
		this.dir = dir;
		this.i = i;
		this.j = j;
		this.alive = true;
	}
}