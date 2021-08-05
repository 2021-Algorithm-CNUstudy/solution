package problem_1873;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int h = scan.nextInt();
			int w = scan.nextInt();

			char[][] arr = new char[h][w];
			for (int i = 0; i < h; i++) {
				String temp = scan.next();
				for (int j = 0; j < w; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}

			int num = scan.nextInt();
			String input = scan.next();

			// 전차 찾기
			int[] answer = new int[] { -1, -1 };
			find(arr, answer);

			int i = answer[0];
			int j = answer[1];

			// 명령 진행하기
			for (int index = 0; index < num; index++) {
				char temp = input.charAt(index);
				check(arr, i, j, temp, answer);

				i = answer[0];
				j = answer[1];
			}

			System.out.print("#" + test_case + " ");
			for (int a = 0; a < h; a++) {
				for (int b = 0; b < w; b++)
					System.out.print(arr[a][b]);
				System.out.println();
			}
		}

		scan.close();
	}

	private static void find(char[][] arr, int[] answer) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				char temp = arr[i][j];
				if (temp == '^' || temp == 'v' || temp == '<' || temp == '>') {
					answer[0] = i;
					answer[1] = j;
					return;
				}
			}
		}
	}

	private static void check(char[][] arr, int i, int j, char input, int[] answer) {
		int newI, newJ;
		answer[0] = i;
		answer[1] = j;

		switch (input) {
		case 'U':
			arr[i][j] = '^';
			newI = i - 1;
			newJ = j;
			if (isRight(arr, newI, newJ)) {
				if (isGround(arr, newI, newJ)) {
					arr[i][j] = '.';
					arr[newI][newJ] = '^';
					answer[0] = newI;
					answer[1] = newJ;
					break;
				}
			}
			break;
		case 'D':
			arr[i][j] = 'v';
			newI = i + 1;
			newJ = j;
			if (isRight(arr, newI, newJ)) {
				if (isGround(arr, newI, newJ)) {
					arr[i][j] = '.';
					arr[newI][newJ] = 'v';
					answer[0] = newI;
					answer[1] = newJ;
					break;
				}
			}
			break;
		case 'L':
			arr[i][j] = '<';
			newI = i;
			newJ = j - 1;
			if (isRight(arr, newI, newJ)) {
				if (isGround(arr, newI, newJ)) {
					arr[i][j] = '.';
					arr[newI][newJ] = '<';
					answer[0] = newI;
					answer[1] = newJ;
					break;
				}
			}
			break;
		case 'R':
			arr[i][j] = '>';
			newI = i;
			newJ = j + 1;
			if (isRight(arr, newI, newJ)) {
				if (isGround(arr, newI, newJ)) {
					arr[i][j] = '.';
					arr[newI][newJ] = '>';
					answer[0] = newI;
					answer[1] = newJ;
					break;
				}
			}
			break;
		case 'S':
			shoot(arr, i, j, answer);
			break;
		}
	}

	private static void shoot(char[][] arr, int i, int j, int[] answer) {
		switch (arr[i][j]) {
		case '^':
			for (int a = i - 1; a >= 0; a--) {
				if (arr[a][j] == '*') {
					arr[a][j] = '.';
					break;
				} else if (arr[a][j] == '#')
					break;
			}
			break;
		case 'v':
			for (int a = i + 1; a < arr.length; a++) {
				if (arr[a][j] == '*') {
					arr[a][j] = '.';
					break;
				} else if (arr[a][j] == '#')
					break;
			}
			break;
		case '<':
			for (int b = j - 1; b >= 0; b--) {
				if (arr[i][b] == '*') {
					arr[i][b] = '.';
					break;
				} else if (arr[i][b] == '#')
					break;
			}
			break;
		case '>':
			for (int b = j + 1; b < arr[0].length; b++) {
				if (arr[i][b] == '*') {
					arr[i][b] = '.';
					break;
				} else if (arr[i][b] == '#')
					break;
			}
			break;
		}
	}

	private static boolean isGround(char[][] arr, int i, int j) {
		if (arr[i][j] == '.')
			return true;
		return false;
	}

	private static boolean isRight(char[][] arr, int i, int j) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length)
			return false;
		return true;
	}
}
