package practice;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int min = 257; // 0~256
		int max = -1; // 0~256
		String [] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int B = Integer.parseInt(input[2]);
		int[][] grand = new int[N][M];
		for (int i = 0; i < N; i++) {
			String [] temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grand[i][j] = Integer.parseInt(temp[j]);
				if (grand[i][j] < min) {
					min = grand[i][j];
				}
				if (grand[i][j] > max) {
					max = grand[i][j];
				}
			}
		}
		int remToMakeBottom = 0; // 최소 높이로는 제거만 하면 되니까 무조건 만들 수 있음
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				remToMakeBottom += grand[i][j] - min;
			}
		}
		int[] result = Mining(min, max, grand, N, M, B, remToMakeBottom);
		System.out.println(result[0] + " " + result[1]);
	}

	public static int[] Mining(int min, int max, int[][] grand, int N, int M, int B, int bottom) {
		int[] result = new int[2];
		int time = 2 * bottom; // 최소 높이를 만들 때 걸리는 시간
		int height = min; // 최소 높이 저장 (이후 갱신을 위한 초기화)
		int remove = 0;
		int make = 0;
		for (int i = min + 1; i < max + 1; i++) { // 모든 높이를 만들어보고, 시간이 짧게 걸리는 것을 베스트로, 시간이 동일하다면 높이를 비교하기
			remove = 0; // 제거할 블록
			make = 0; // 생성할 블록
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (grand[j][k] > i) {
						remove += grand[j][k] - i;
					} else if (grand[j][k] < i) {
						make += i - grand[j][k];
					}
				}
			}
			if(remove + B >= make) { // 만들 수 있다면
				if(time >= remove * 2 + make) { // 시간 비교해보고 짧으면
					time = remove * 2 + make; // 시간 갱신
					height = i; // 높이 갱신
				}
			}
		}
		result[0] = time;
		result[1] = height;
		return result;
	}
}
