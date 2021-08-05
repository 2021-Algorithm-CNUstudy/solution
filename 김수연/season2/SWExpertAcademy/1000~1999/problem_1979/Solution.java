package problem_1979;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			int K = scan.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					arr[i][j] = scan.nextInt();
			}

			int answer = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= (N - K); j++) {
					if (arr[i][j] == 1) {	// 가로 검사
						if (j != 0) {	// 이전 값 체크
							if (arr[i][j - 1] == 1)
								continue;
						}

						for (int k = 1; k < K; k++) {
							if (arr[i][j] != arr[i][j + k])	// 다음칸과 색이 같아야한다.
								break;
							
							if (K - 1 == k) {	// 마지막 검사일 때,
								if (j + k + 1 >= N) {	// 다음 칸이 배열 크기 넘어가는 경우
									answer++;
									break;
								}
								if (arr[i][j + k + 1] == 0)	// 다음 칸이 검은색인 경우 성공
									answer++;
							}
						}
					}

				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= (N - K); j++) {
					if (arr[j][i] == 1) {	// 세로 검사
						if (j != 0) {	// 이전 값 체크
							if (arr[j - 1][i] == 1)
								continue;
						}
						for (int k = 1; k < K; k++) {
							if (arr[j][i] != arr[j + k][i])// 다음 칸과 색이 같아야한다.
								break;
							if (K - 1 == k) {
								if (j + k + 1 >= N) {
									answer++;
									break;
								}
								if (arr[j + k + 1][i] == 0) {
									answer++;
								}
							}
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}

		scan.close();
	}
}
