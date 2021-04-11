package day5;

import java.util.Scanner;

public class BOJ1780_종이의개수 {
	static int a, b, c;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		a = 0;
		b = 0;
		c = 0;
		paper(arr, N);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}

	public static void paper(int[][] arr, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] != arr[0][0]) {
					for (int div = 0; div < 3; div++) {
						for (int div2 = 0; div2 < 3; div2++) {
							int[][] newarr = new int[size / 3][size / 3];
							for (int k = 0; k < size / 3; k++) {
								for (int l = 0; l < size / 3; l++) {
									newarr[k][l] = arr[div*(size/3)+k][div2*(size/3)+l];
								}
							}
							paper(newarr,size/3);
						}
					}
					return;
				}
			}
		}
		if(arr[0][0] == -1) {
			a++;
		} else if(arr[0][0] == 0) {
			b++;
		} else {
			c++;
		}

	}

}
