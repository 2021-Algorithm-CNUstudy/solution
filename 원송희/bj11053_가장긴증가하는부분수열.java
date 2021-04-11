package Practice;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int [] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		int [] count = new int[N];
		count[0] = 1;
		for(int i = 1; i < N; i++) {
			count[i] = 1;
			int max = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[i] > arr[j]) {
					if(max < count[j]) {
						max = count[j];
					}
				}
			}
			count[i] += max;
		}
		Arrays.sort(count);
		System.out.println(count[N - 1]);
	}
}
