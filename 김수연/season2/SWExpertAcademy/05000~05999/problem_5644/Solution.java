package problem_5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			int[] aDir = new int[m + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; ++i)
				aDir[i] = Integer.parseInt(st.nextToken());

			int[] bDir = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; ++i)
				bDir[i] = Integer.parseInt(st.nextToken());

			int[][] ba = new int[a][4];
			for (int k = 0; k < a; ++k) {
				st = new StringTokenizer(br.readLine());
				ba[k][1] = Integer.parseInt(st.nextToken()) - 1; // j
				ba[k][0] = Integer.parseInt(st.nextToken()) - 1; // i
				ba[k][2] = Integer.parseInt(st.nextToken()); // coverage
				ba[k][3] = Integer.parseInt(st.nextToken()); // performance
			}

			Arrays.sort(ba, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[3] - o1[3];
				}
			});

			int answer = 0; // a, b 충전량
			int aPosI = 0, aPosJ = 0, bPosI = 9, bPosJ = 9; // a, b 좌표
			int[] di = { 0, -1, 0, 1, 0 };
			int[] dj = { 0, 0, 1, 0, -1 };
			for (int dir = 0; dir <= m; ++dir) {
				ArrayList<Integer> aPos = new ArrayList<>();
				for (int k = 0; k < a; ++k) {
					if (distance(aPosI, aPosJ, ba[k][0], ba[k][1]) <= ba[k][2])
						aPos.add(k);
				}

				ArrayList<Integer> bPos = new ArrayList<>();
				for (int k = 0; k < a; ++k) {
					if (distance(bPosI, bPosJ, ba[k][0], ba[k][1]) <= ba[k][2])
						bPos.add(k);
				}
				
				int aSize = aPos.size();
				int bSize = bPos.size();
				int overlapIndex = -1;

				find: for (int i = 0; i < aSize; ++i) {
					for (int j = 0; j < bSize; ++j) {
						if (aPos.get(i) == bPos.get(j)) {
							overlapIndex = aPos.get(i);
							break find;
						}
					}
				}

				if (overlapIndex == -1) {
					if (aSize != 0) answer += ba[aPos.get(0)][3];
					if (bSize != 0) answer += ba[bPos.get(0)][3];
				} else {
					if (aSize == 1) {
						if (bSize == 1)
							answer += ba[aPos.get(0)][3];
						else if (bSize > 1) {
							answer += (overlapIndex == bPos.get(0)) 
									? (ba[aPos.get(0)][3] + ba[bPos.get(1)][3])
									: (ba[aPos.get(0)][3] + ba[bPos.get(0)][3]);
						}
					} else if (aSize > 1) {
						if (bSize == 1) {
							answer += (overlapIndex == aPos.get(0))
									? (ba[aPos.get(1)][3] + ba[bPos.get(0)][3])
									: (ba[aPos.get(0)][3] + ba[bPos.get(0)][3]); 
						} else if (bSize > 1) {
							if (aPos.get(0) == overlapIndex && bPos.get(0) == overlapIndex)
								answer += ba[aPos.get(0)][3] 
										+ Math.max(ba[aPos.get(1)][3], ba[bPos.get(1)][3]);
							else  {
								answer += ba[aPos.get(0)][3] + ba[bPos.get(0)][3];
							}
						}
					}
				}

				// 위치 이동
				if (dir == m)
					break;
				
				aPosI += di[aDir[dir]];
				aPosJ += dj[aDir[dir]];
				bPosI += di[bDir[dir]];
				bPosJ += dj[bDir[dir]];
			}

			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}

	private static int distance(int ai, int aj, int bi, int bj) {
		return Math.abs(ai - bi) + Math.abs(aj - bj);
	}
}