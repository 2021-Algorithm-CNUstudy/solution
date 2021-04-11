package day8kakao2020;

import java.util.Scanner;

public class Kakao2020_자물쇠와열쇠 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		boolean answer = false;
		int offset = key.length-1;
		
		for (int r = 0; r < offset + lock.length; r++) {
			for (int c = 0; c < offset + lock.length; c++) {
				for (int rot = 0; rot < 4; rot++) {
					int[][] arr = new int[58][58];
					for (int i = 0; i < lock.length; i++) {
						for (int j = 0; j < lock.length; j++) {
							arr[offset + i][offset + j] = lock[i][j];
						}
					}
					key = rotate(key);
					for (int i = 0; i < key.length; i++) {
						for (int j = 0; j < key.length; j++) {
							arr[r+i][c+j] += key[i][j];
						}
					}
					if(check(arr, offset, lock.length)) {
						//return true;
					}
				}
			}
		}
		// return false;
		
	}
	static boolean check(int[][] arr, int offset, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[offset+i][offset+j] !=1) {
					return false;
				}
			}
		}
		return true;
	}
	public static int[][] rotate(int[][] matrix) {
	    int n = matrix.length;

	    for (int i = 0; i < n / 2; i++) {
	        for (int j = 0; j < n; j++) {
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[n - i - 1][j];
	            matrix[n - i - 1][j] = temp;

	        }
	    }

	    for (int i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	    return matrix;
	}
}
