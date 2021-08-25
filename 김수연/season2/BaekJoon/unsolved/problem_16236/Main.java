package problem_16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, time = 0;
	static int[] shark, fish;
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					shark = new int[] {i, j, 2, 0};
				}
			}
		}
		
		findFish();
		bw.write(time + "\n");
		
		br.close();
		bw.close();
	}
	
	private static void findFish() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {shark[0], shark[1]});
		visited = new boolean[n][n];
		visited[shark[0]][shark[1]] = true;
		
		int lvl = 0;
		while (! q.isEmpty()) {
			int size = q.size();
			++lvl;
			for (int i = 0; i < size; ++i) {
				int[] loc = q.poll();
				for (int d = 0; d < 4; ++d) {
					int ni = loc[0] + di[d];
					int nj = loc[1] = dj[d];
					
					if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
					if (visited[ni][nj]) continue;
					if (shark[2] < arr[ni][nj]) continue;
					
					visited[ni][nj] = true;
					if ((arr[ni][nj] == 0) || (shark[2] == arr[ni][nj])) {
						q.add(new int[] {ni, nj});
						continue;
					}
					
					if (fish == null) {
						fish = new int[] {ni, nj};
						continue;
					}
					
					if (fish[0] > ni || (fish[0] == ni && fish[1] > nj)) {
						fish[0] = ni;
						fish[1] = nj;
					}
				}
			}
			if (fish != null) {
				time += lvl;
				++shark[3];
				if (shark[2] == shark[3]) {
					++shark[2];
					shark[3] = 0;
				}
				arr[shark[0]][shark[1]] = 0;
				shark[0] = fish[0];
				shark[1] = fish[1];
				
				q.clear();
				
				q.add(new int[] {shark[0], shark[1]});
				visited = new boolean[n][n];
				visited[shark[0]][shark[1]] = true;
				lvl = 0;
				fish = null;
			}
		}
	}
}