package algorithm18;

// 아파트 색칠하기 문제를 풀어 보세요.
// 아파트를 각 층 별로 파란색 또는 노란색 페인트로 칠하되 다음과 같은 규칙으로 칠하려고 한다.
// 노란색은 인접한 두 층에 연속하여 사용할 수 있다.
// 파란색은 인접한 두 층에 연속하여 사용할 수 없다.
// 이와 같은 규칙으로 층의 아파트를 칠할 수 있는 방법의 수를 f(n)이라 하면 다음 그림과 같이
// f(1) = 2, f(2) = 3이다. f(8)은 얼마인가?
public class Practice01 {
	public static void main(String[] args) {
		System.out.println(f(4));
	}
	
	public static int f(int n) {
		int[] f = new int[n + 1];
		f[1] = 2;
		f[2] = 3;
		
		for (int i = 3; i <= n; ++i) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n];
	}
}
