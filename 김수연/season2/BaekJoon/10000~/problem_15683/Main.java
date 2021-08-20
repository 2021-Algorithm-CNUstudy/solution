package problem_15683;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cctvCount, wallCount, min = 64;
	static int[] cctvDirection, di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1}, available = {0, 4, 2, 4, 4, 1};
	static int[][] arr, clone;
	static ArrayList<CCTV> cctvPos;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cctvPos = new ArrayList<>();
		arr = new int[n][m];
		clone = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6)
					cctvPos.add(new CCTV(i, j, arr[i][j]));
				if (arr[i][j] == 6) ++wallCount;
				clone[i][j] = arr[i][j];
			}
		}
		
		cctvCount = cctvPos.size();
		cctvDirection = new int[cctvCount];
		permutation(0);
		bw.write(min + "\n");
		
		br.close();
		bw.close();
	}
	
	private static void permutation(int count) {
		if (count == cctvCount) {
			for (int i = 0; i < cctvCount; ++i) {
				if (cctvPos.get(i).num == 2) {
					if (cctvDirection[i] >= 2)
						return;
				}
				
				if (cctvPos.get(i).num == 5) {
					if (cctvDirection[i] >= 1)
						return;
				}
			}
			cctvOn();
			clear();
			return;
		}

		for (int i = 0; i < 4; i++) {
			cctvDirection[count] = i;
			permutation(count + 1);
		}
	}
	
	private static void cctvOn() {
		// 지정된 방향으로 불 키고 사각지대 계산하여 값과 비교
		int on = 0;
		for (int i = 0; i < cctvCount; ++i) {
			CCTV cctv = cctvPos.get(i);// 여기 수정
			for (int dir = 0; dir < cctv.dir.length; ++dir) {
				int cctvDir = cctv.dir[dir] + cctvDirection[i];
				cctvDir %= 4;
				int newI = cctv.i + di[cctvDir];
				int newJ = cctv.j + dj[cctvDir];
				while (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
					if (arr[newI][newJ] == 6) break;
					if (arr[newI][newJ] == 0) {
						arr[newI][newJ] = 9;
						++on;
					}
					
					newI += di[cctvDir];
					newJ += dj[cctvDir];
				}
			}
		}
		
		int answer = n * m - wallCount - cctvCount - on;
		if (min > answer) min = answer;
	}
	
	private static void clear() {
		for (int i = 0; i < n; ++i)
			System.arraycopy(clone[i], 0, arr[i], 0, m);
	}
}

class CCTV {
	int i, j, num;
	int[] dir;
	
	CCTV(int i, int j, int num) {
		this.i = i;
		this.j = j;
		this.num = num;
		
		// dir -> cctv가 가리키는 방향, 12시 -> 0 3시 -> 1
		if (num == 1) this.dir = new int[] {1};
		else if (num == 2) this.dir = new int[] {1, 3};
		else if (num == 3) this.dir = new int[] {0, 1};
		else if (num == 4) this.dir = new int[] {0, 1, 3};
		else if (num == 5) this.dir = new int[] {0, 1, 2, 3};
	}
}