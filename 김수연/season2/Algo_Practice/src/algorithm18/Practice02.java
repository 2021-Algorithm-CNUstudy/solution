package algorithm18;

// 막대기 색칠하기 문제를 풀어 보세요.
public class Practice02 {
	public static void main(String[] args) {
		System.out.println(f(6));
	}
	
	public static int f(int n) {
		int[] f = new int[n + 1];
		
		f[0] = 1;
		f[1] = 2; // 파랑, 노랑
		
		for (int i = 2; i <= n; ++i) {
			f[i] = f[i - 1] * 2 + f[i - 2];
		}
		
		return f[n];
	}
}
