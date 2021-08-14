package problem_1493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Point {
	int x, y, num;
	
	Point(int num) {
		this.num = num;
		
		int start = 1, end = 1;
		int temp = 0;
		while (start <= num) {
			end = start;
			start += temp;
			++temp;
		}
		
		int newX = 1;
		int newY = temp - 1;
		while (end != num) {
			--newY;
			++newX;
			end++;
		}
		
		this.x = newX;
		this.y = newY;
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		
		while (x != 1) {
			--x;
			++y;
		}
		
		int num = 1;
		int newY = 1;
		while (y != newY) {
			num += newY;
			++newY;
		}
		
		int newX = 1;
		while (! (this.x == newX && this.y == newY)) {
			++newX;
			--newY;
			++num;
		}
		
		this.num = num;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Point pointA = new Point(Integer.parseInt(st.nextToken()));
			Point pointB = new Point(Integer.parseInt(st.nextToken()));
			
			Point pointC = new Point(pointA.x + pointB.x, pointA.y + pointB.y);
			
			bw.write("#" + test_case + " " + pointC.num + "\n");
		}
		br.close();
		bw.close();
	}
}