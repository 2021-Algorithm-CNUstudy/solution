package Practice;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int [] answer = new int[1000]; // 범위 아니까
		answer[0] = 1;
		answer[1] = 3;
		for(int i = 2; i < 1000; i++) {
			answer[i] = (answer[i - 1] + (2 * answer[i - 2])) % 10007;
		}
		System.out.println(answer[N - 1]);
	}
}
