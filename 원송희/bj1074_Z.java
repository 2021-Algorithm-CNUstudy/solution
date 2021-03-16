package Practice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int size = 1;
		for(int i = 0; i < N; i++) {
			size *= 2;
		}
		int r = input.nextInt();
		int c = input.nextInt();
		int row = 0;
		int column = 0; // 시작점
		int cnt = 0;
		while (true) {
			size /= 2;
			// 좌측 상단에 있으면 아무것도 할 필요 x
			// 우측 상단에 있으면
			if(r < row + size && c >= column + size) {
				cnt += size * size;
				column += size;
			}
      // 좌측 하단에 있으면
			if(r >= row + size && c < column + size) {
				cnt += size * size * 2;
				row += size;
			}
      // 우측 하단에 있으면
			if(r >= row + size && c >= column + size) {
				cnt += size * size * 3;
				row += size;
				column += size;
			}
			if(size == 1) {
				System.out.println(cnt);
				break;
			}
		}
	}
}
