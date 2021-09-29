package problem_1194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int n, m;
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int curI = -1, curJ = -1;
		arr = new char[n][m];
		for (int i = 0; i < n; ++i) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; ++j) {
				if (arr[i][j] == '0') {
					curI = i;
					curJ = j;
					arr[i][j] = '.';
				}
			}
		}
		
		bw.write(bfs(curI, curJ) + "\n");
		
		br.close();
		bw.close();
	}
	
	// 현재 위치에서 출구로 바로 갈 수 있는지 확인하는 함수
	private static int bfs(int startI, int startJ) {
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(startI, startJ, 0, 0));
		boolean[][][] isVistited = new boolean[n][m][1 << 6];
		isVistited[startI][startJ][0] = true;

		while (! que.isEmpty()) {
			Pos p = que.poll();
			
			for (int dir = 0; dir < 4; ++dir) {
				int ni = p.i + di[dir];
				int nj = p.j + dj[dir];
				
				// 범위
				if (ni < 0 || ni >= n || nj < 0 || nj >= m)
					continue;
				
				// answer
				if (arr[ni][nj] == '1')
					return p.count + 1;
				
				// 벽
				else if (arr[ni][nj] == '#')
					continue;
				
				// 키
				else if (arr[ni][nj] >= 'a' && arr[ni][nj] <= 'f') {
					if (! isVistited[ni][nj][p.key]) {
						isVistited[ni][nj][p.key] = true;
						que.offer(new Pos(ni, nj, p.key | (1 << (arr[ni][nj] - 'a')), p.count + 1));
					}
				}
				
				// 문
				else if (arr[ni][nj] >= 'A' && arr[ni][nj] <= 'F') {
					if (! isVistited[ni][nj][p.key]) {
						isVistited[ni][nj][p.key] = true;
						if ((p.key & (1 << (arr[ni][nj] - 'A'))) != 0)
							que.offer(new Pos(ni, nj, p.key, p.count + 1));
					}
				}
				
				// 길
				else {
					if (! isVistited[ni][nj][p.key]) {
						isVistited[ni][nj][p.key] = true;
						que.offer(new Pos(ni, nj, p.key, p.count + 1));
					}
				}
			}
		}
		
		return -1;
	}
}

class Pos {
	int i, j, key, count;
	
	Pos (int i, int j, int key, int count) {
		this.i = i;
		this.j = j;
		this.key = key;
		this.count = count;
	}
}