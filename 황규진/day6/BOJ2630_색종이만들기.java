package day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630_색종이만들기 {
//	static int N;
//	static int[][] arr;
	static int white, blue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		white = 0;
		blue = 0;
		paper(arr, N);
		System.out.println(white);
		System.out.println(blue);

	}
	public static void paper(int[][] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] != arr[0][0]) {
					for (int k = 0; k < 2; k++) {
						for (int k2 = 0; k2 < 2; k2++) {
							int[][] tmp = new int[n/2][n/2];
							for (int l = 0; l < n/2; l++) {
								for (int l2 = 0; l2 < n/2; l2++) {
									tmp[l][l2] = arr[k*n/2+l][k2*n/2+l2];
								}
							}
							paper(tmp, n/2);
						}
					}
					return;
				}
			}
		}
		if(arr[0][0] == 0)
			white++;
		else
			blue++;
		
	}
}
