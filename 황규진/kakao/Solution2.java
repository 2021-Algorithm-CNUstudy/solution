package kakao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution2 {
	static int result;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] needs = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int r = 2;
		int[] sum = new int[needs[0].length];
		int[] arr = new int[needs.length];
		for (int i = 0; i < needs.length; i++) {
			int count = 0;
			boolean[] visited = new boolean[needs[0].length];
			String tmp = comb(needs[i], visited, 0, r);
			if(tmp != null) {
				String[] s = tmp.split("");
				for (int j = 0; j < s.length; j++) {
					if(j == Integer.parseInt(s[j])) {
					} else {
						if(needs[i][j] == 1) {
							count++;
						}
					}
					needs[i][Integer.parseInt(s[j])] = 1;
				}
			}
			arr[i] = result;
		}
		

	}
	static String comb(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            return print(arr, visited);
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
		return null;
    }
	static String print(int[] arr, boolean[] visited) {
		String tmp = "";
        for(int i = 0; i < arr.length; i++) {
        	if(visited[i] == true) {
        		tmp += i;
        	}
        }
        return tmp;
    }

}
