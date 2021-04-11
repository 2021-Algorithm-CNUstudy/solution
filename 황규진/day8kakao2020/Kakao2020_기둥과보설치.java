package day8kakao2020;

import java.util.Arrays;
import java.util.LinkedList;

public class Kakao2020_기둥과보설치 {

	public static void main(String[] args) {

		int n = 5;
		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		int count = 0;
		int[][][] arr = new int[n + 1][n + 1][2];
		for (int i = 0; i < build_frame.length; i++) {
			if (build_frame[i][3] == 1) {
				if (build_frame[i][2] == 0) {
					if (build_frame[i][1] == 0 || arr[build_frame[i][0]-1][build_frame[i][1]][1] == 1
							|| arr[build_frame[i][0]][build_frame[i][1] - 1][0] == 1) {
						arr[build_frame[i][0]][build_frame[i][1]][0] = 1;
					} else {
						continue;
					}
				} else if (build_frame[i][2] == 1) {
					if (arr[build_frame[i][0]][build_frame[i][1]-1][0] == 1 || (arr[build_frame[i][0]][build_frame[i][1]][1] == 1) && (arr[build_frame[i][0]-1][build_frame[i][1]][1] == 1)) {
						arr[build_frame[i][0]][build_frame[i][1]][1] = 1;
					} else {
						continue;
					}
				}
				count++;
			} else {
				if(build_frame[i][2] == 0) {
					arr[build_frame[i][0]][build_frame[i][1]][0] = 0;
				} else if (build_frame[i][2] == 1) {
					arr[build_frame[i][0]][build_frame[i][1]][1] = 0;
				}
				count--;
			}
		}
		int[][] result = new int[count][3];
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j][0] == 1) {
					result[tmp][0] = i;
					result[tmp][1] = j;
					result[tmp][2] = 0;
					tmp++;
				} else if (arr[i][j][1] == 1) {
					result[tmp][0] = i;
					result[tmp][1] = j;
					result[tmp][2] = 1;
					tmp++;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

}
