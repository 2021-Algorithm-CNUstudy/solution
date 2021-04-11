package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2798_블랙잭 {
	// 조합을 통해 최대값을 구하는 문제
	static int M;
	static int max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		str = br.readLine();
		st = new StringTokenizer(str);
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[arr.length];
		combination(arr, visited, 0, 3);

		System.out.println(max);
	}
	static void combination(int[] arr, boolean[] visited, int start, int r) {
		if(r == 0) {
            print(arr, visited);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
	}
	static void print(int[] arr, boolean[] visited) {
		int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
            	sum += arr[i];
            }
        }
        if(sum <= M && max < sum)
        	max = sum;
    }
}
