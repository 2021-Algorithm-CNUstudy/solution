package problem_16935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static String[][] arr;
	static int n, m, r;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new String[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j)
				arr[i][j] = st.nextToken();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; ++i) {
			int input = Integer.parseInt(st.nextToken());
			
			switch (input) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 4:
				method4();
				break;
			case 5:
				method5();
				break;
			case 6:
				method6();
				break;
			}
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j)
				bw.write(arr[i][j] + " ");
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}

	private static void method1() {
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < m; ++j) {
				String temp = arr[i][j];
				arr[i][j] = arr[n - i - 1][j];
				arr[n - i - 1][j] = temp;
			}
		}
	}

	private static void method2() {
		for (int i = 0; i < m / 2; ++i) {
			for (int j = 0; j < n; ++j) {
				String temp = arr[j][i];
				arr[j][i] = arr[j][m - i - 1];
				arr[j][m - i - 1] = temp;
			}
		}
	}

	private static void method3() {
		String[][] temp = arr.clone();
		arr = new String[m][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				arr[j][n - i - 1] = temp[i][j];
			}
		}

		n = arr.length;
		m = arr[0].length;
	}

	private static void method4() {
		String[][] temp = arr.clone();
		arr = new String[m][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				arr[m - j - 1][i] = temp[i][j];
			}
		}

		n = arr.length;
		m = arr[0].length;
	}

	private static void method5() {
		String[][] arr1 = new String[n / 2][m / 2];
		String[][] arr2 = new String[n / 2][m / 2];
		String[][] arr3 = new String[n / 2][m / 2];
		String[][] arr4 = new String[n / 2][m / 2];
		
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < m / 2; ++j) {
				arr1[i][j] = arr[i][j];
				arr2[i][j] = arr[i][j + m / 2];
				arr3[i][j] = arr[i + n / 2][j + m / 2];
				arr4[i][j] = arr[i + n / 2][j];
			}
		}
		
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < m / 2; ++j) {
				arr[i][j + m / 2] = arr1[i][j];
				arr[i + n / 2][j + m / 2] = arr2[i][j];
				arr[i + n / 2][j] = arr3[i][j];
				arr[i][j] = arr4[i][j];
			}
		}
	}

	private static void method6() {
		String[][] arr1 = new String[n / 2][m / 2];
		String[][] arr2 = new String[n / 2][m / 2];
		String[][] arr3 = new String[n / 2][m / 2];
		String[][] arr4 = new String[n / 2][m / 2];
		
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < m / 2; ++j) {
				arr1[i][j] = arr[i][j];
				arr2[i][j] = arr[i][j + m / 2];
				arr3[i][j] = arr[i + n / 2][j + m / 2];
				arr4[i][j] = arr[i + n / 2][j];
			}
		}
		
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < m / 2; ++j) {
				arr[i + n / 2][j] = arr1[i][j];
				arr[i][j] = arr2[i][j];
				arr[i][j + m / 2] = arr3[i][j];
				arr[i + n / 2][j + m / 2] = arr4[i][j];
			}
		}
	}
}