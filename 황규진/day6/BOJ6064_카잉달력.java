package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ6064_카잉달력 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int count = 0;
			// 두 수의 차이가 최대공약수로 나누어 지는가.
			// 최대공약수
			// M * y / x + x ???
			int div = ea(M,N);
			boolean can = false;
			boolean check = false;
			if(Math.abs(x-y) % div == 0) {
				can = true;
			}
			if(M == N) {
				can = false;
				check = true;
				if(x == y)
					System.out.println(x);
				else
					System.out.println(-1);
			}
			calendar cd = new calendar(1,1);
			while(can) {
				count++;
				if((M*count+x)%N == y%N) {
					System.out.println(M*count+x);
					check = true;
					break;
				}
			}
//			calendar cd = new calendar(1,1);
//			while(can) {
//				count++;
//				if(cd.x == M && cd.y == N)
//					break;
//				if(cd.x == x && cd.y == y) {
//					System.out.println(count);
//					check = true;
//					break;
//				}
//				cd.x = cd.x + 1;
//				cd.y = cd.y + 1;
//				if(cd.x > M)
//					cd.x = 1;
//				if(cd.y > N)
//					cd.y = 1;
//			}
			if(!check)
				System.out.println(-1);
			
		}
	
	}
	static int ea(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return ea(y, x%y);
		}
	}

}
class calendar {
	int x;
	int y;
	public calendar(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
