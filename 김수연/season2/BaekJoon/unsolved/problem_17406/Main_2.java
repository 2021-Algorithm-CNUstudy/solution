package problem_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static int[][] rotates;
	static List<int[]> perms;
	static int[] temp;
	static boolean[] isChecked;
	static int[][] copy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		rotates = new int[k][3];
		perms = new ArrayList<int[]>();
		temp = new int[k];
		isChecked = new boolean[k];
		
		int min = Integer.MAX_VALUE;
		
		// 숫자 배열 채우기
		for(int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0; j < m; j++)
				 arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 회전 규칙 배열 채우기
		for(int i = 0; i < k; i ++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotates[i] = new int[]{r - s - 1, c - s - 1, s}; // 회전하는 사각형의 맨 왼쪽 위 x, y값과  s값 저장
		}
		
		// 회전 방법 조합 만들기
		perm(0);
		
		for(int[] perm:perms) {
			// arr 복사본 저장 
			copy = new int[n][m];
			for(int i = 0; i < n; i ++)
				System.arraycopy(arr[i], 0, copy[i], 0,  m);
			
			for(int p: perm)
				rotate(rotates[p][0], rotates[p][1], rotates[p][2]);
			
			// min 값 찾기
			for(int i = 0; i < n; i ++) {
				int sum = 0;
				for(int j = 0; j < m; j ++) {
					sum += copy[i][j];
				}
				min = Math.min(min, sum);
			}
		}
		
		System.out.println(min);
	}
	
	// 회전방법 조합 구하기
	private static void perm(int n) {
		if(n == k) {
			perms.add(temp.clone());
			return;
		}
		
		for(int i = 0; i < k; i++) {
			if(!isChecked[i]) {
				temp[n] = i;
				isChecked[i] = true;
				perm(n + 1);
				isChecked[i] = false;
			}
		}
	}
	
	// 회전하기
	private static int[][] rotate(int ix, int iy, int s) {
		for(int i = 0; i < s; i++) {
			int x = ix + i;
			int y = iy + i;
			int temp = copy[x][y];
			
			for(int d = 0; d < 4; d++) {
				while(true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < ix + i || ny < iy + i || nx > (ix + 2 * s - i)  || ny > (iy + 2 * s - i)) break;
					copy[x][y] = copy[nx][ny];
					x = nx;
					y = ny;
				}
			}
			copy[ix + i][iy + i + 1] = temp;
		}

		return copy;
	}
}