package problem_3131;

public class Solution {
	public static void main(String[] args) {
		boolean[] list = new boolean[1000000];
		
		// 2를 제외한 짝수 true 만들기
		int i = 2;
		int plus = i;
		while (i + plus < 1000000) {
			list[i + plus] = true;
			plus += i;
		}
		
		for (i = 3; i < 1000000; i += 2) {
			if (list[i]) continue;
			plus = i;
			while (i + plus < 1000000) {
				list[i + plus] = true;
				plus += i;
			}
		}
		
		// test
		for (i = 2; i < 1000000; ++i) {
			if (! list[i]) {
				System.out.print(i + " ");
			}
		}
	}
}