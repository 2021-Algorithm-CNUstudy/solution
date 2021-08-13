package problem_15686;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
	int i, j;
	
	Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class Main {
	static int n, m, totalDist = 0, answer = Integer.MAX_VALUE;
	static int[] sel;
	static int[][] dist;
	static ArrayList<Pos> house = new ArrayList<>();
	static ArrayList<Pos> chicken = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1)
					house.add(new Pos(i, j));
				else if (input == 2)
					chicken.add(new Pos(i, j));
			}
		}
		
		int hSize = house.size();
		int cSize = chicken.size();
		dist = new int[hSize][cSize];
		for (int i = 0; i < hSize; ++i) {
			for (int j = 0; j < cSize; ++j) {
				Pos hPos = house.get(i);
				Pos cPos = chicken.get(j);
				dist[i][j] = Math.abs(hPos.i - cPos.i) + Math.abs(hPos.j - cPos.j);
			}
		}
		
		sel = new int[m];
		comb(0, 1);
		
		bw.write(String.valueOf(answer));
		
		br.close();
		bw.close();
	}
	
	private static void comb(int count, int start) {
		if (count == m) {
			for (int i = 0; i < house.size(); ++i) {
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < sel.length; ++j)
					minDist = Math.min(minDist, dist[i][sel[j]]);
				totalDist += minDist;
			}
			answer = Math.min(answer, totalDist);
			totalDist = 0;
			return;
		}
		
		for (int i = start; i <= chicken.size(); ++i) {
			sel[count] = (i - 1);
			comb(count + 1, i + 1);
		}
	}
}