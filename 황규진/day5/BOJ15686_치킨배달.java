package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15686_치킨배달 {
	static int N,M;
	static int[][] arr;
	static int chicken;
	static int house;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		chicken = 0;
		house = 0;
		Queue<Point3> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					house++;
					queue.add(new Point3(i, j));
				}
				else if(arr[i][j] == 2) {
					chicken++;
				}
			}
		}
		
	}
}
class Point3 {
//	int[] distance = new int[house];
	int x;
	int y;
	Point3(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
