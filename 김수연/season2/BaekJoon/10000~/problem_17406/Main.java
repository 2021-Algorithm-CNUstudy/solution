package problem_17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, answer, list;
	static int n, m, k, min;
	static Integer[] numbers;
	static boolean[] isSelected;
	static ArrayList<Integer[]> arrayList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		list = new int[k][3];
		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken()) - 1;
			list[i][1] = Integer.parseInt(st.nextToken()) - 1;
			list[i][2] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		arrayList = new ArrayList<>();
		
		for (int i = 1; i <= k; ++i) {
			numbers = new Integer[i];
			isSelected = new boolean[k + 1];
			
			permutation(0, i);
		}
		
		answer = new int[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j)
				answer[i][j] = arr[i][j];
		}
		
		for (int i = 0; i < arrayList.size(); ++i) {
			Integer[] check = arrayList.get(i);
			for (int j = 0; j < check.length; ++j) {
				int r = list[check[j]][0];
				int c = list[check[j]][1];
				int s = list[check[j]][2];
				rotate(r, c, s);
			}
			
			int temp = min();
			if (min > temp)
				min = temp;
			
			for (int a = 0; a < n; ++a) {
				for (int b = 0; b < m; ++b)
					arr[a][b] = answer[a][b];
			}
		}
		
		bw.write(String.valueOf(min));
		
		br.close();
		bw.close();
	}

	private static void permutation(int count, int num) {
		if (count == num) {
			arrayList.add(numbers.clone());
			return;
		}

		for (int i = 0; i < k; i++) {
			if (isSelected[i])
				continue;
			
			numbers[count] = i;
			isSelected[i] = true;
			
			permutation(count + 1, num);
			isSelected[i] = false;
		}
	}
	
	private static void rotate(int r, int c, int s) {
		for (int count = 0; count < s; ++count) {
			int i = r - s + count, j = c - s + count;
			int temp = arr[i][j];
			
			while (i < r + s - count) {
				arr[i][j] = arr[i + 1][j];
				++i;
			}
			
			while (j < c + s - count) {
				arr[i][j] = arr[i][j + 1];
				++j;
			}
			
			while (i > r - s + count) {
				arr[i][j] = arr[i - 1][j];
				--i;
			}
			
			while (j > c - s + count) {
				arr[i][j] = arr[i][j - 1];
				--j;
			}
			
			arr[i][j+1] = temp;
		}
	}
	
	private static int min() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			int sum = 0;
			for (int j = 0; j < m; ++j)
				sum += arr[i][j];
			if (min > sum)
				min = sum;
		}
		return min;
	}
}