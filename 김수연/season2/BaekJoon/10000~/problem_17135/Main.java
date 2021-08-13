package problem_17135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pos {
	int i, j;
	int[] dist = new int[3];
	Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class Main {
	static int n, m, d, killCount, maxScore;
	static int[] archerIndex;
	static ArrayList<Pos> enemy = new ArrayList<>();
	static ArrayList<Pos> enemyCopy = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) enemy.add(new Pos(i, j));
			}
		}
		
		for (int i = 0; i < enemy.size(); ++i) {
			enemyCopy.add(new Pos(enemy.get(i).i, enemy.get(i).j));
		}
		
		maxScore = Integer.MIN_VALUE;
		archerIndex = new int[3];
		comb(0, 1);
		
		bw.write(String.valueOf(maxScore));
		
		br.close();
		bw.close();
	}
	
	private static void comb(int count, int start) {
		if (count == 3) {
			defence();
			reset();
			return;
		}
		
		for (int i = start; i <= m; ++i) {
			archerIndex[count] = i - 1;
			comb(count + 1, i + 1);
		}
	}
	
	private static void defence() {
		killCount = 0;
		Pos[] archerPos = new Pos[3];
		for (int i = 0; i < 3; ++i)
			archerPos[i] = new Pos(n, archerIndex[i]);
		
		while (enemy.size() != 0) {
			// enemy마다 궁수와의 거리 추가
			for (int i = 0; i < 3; ++i) {
				Pos archer = archerPos[i];
				for (int j = 0; j < enemy.size(); ++j)
					enemy.get(j).dist[i] = distance(archer.i, archer.j, enemy.get(j).i, enemy.get(j).j);
			}
			
			ArrayList<Pos> killList = new ArrayList<>();
			nextArcher: for (int i = 0; i < 3; ++i) {
				sort(i);
				
				for (int dist = 1; dist <= d; ++dist) {
					for (int j = 0; j < enemy.size(); ++j) {
						if (enemy.get(j).dist[i] == dist) {
							if (! killList.contains(enemy.get(j)))
								killList.add(enemy.get(j));
							continue nextArcher;
						}
					}
				}
			}
			
			killCount += killList.size();
			int size = enemy.size();
			for (int i = size - 1; i >= 0 ; --i) {
				if (killList.contains(enemy.get(i)))
					enemy.remove(i);
			}
			move();
		}
		maxScore = maxScore < killCount ? killCount : maxScore;
	}
	
	private static void sort(int archer) {
		enemy.sort(new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				if (o1.dist[archer] == o2.dist[archer])
					return o1.j - o2.j;
				return o1.dist[archer] - o2.dist[archer];
			}
		});
	}
	
	private static void move() {
		for (int i = enemy.size() - 1; i >= 0; --i) {
			Pos pos = enemy.get(i);
			if (pos.i + 1 >= 0 && pos.i + 1 < n) {
				pos.i += 1;
				for (int j = 0; j < 3; ++j)
					pos.dist[j] -= 1;
				enemy.set(i, pos);
			} else
				enemy.remove(i);
		}
	}
	
	private static void reset() {
		enemy.clear();
		for (int i = 0; i < enemyCopy.size(); ++i)
			enemy.add(new Pos(enemyCopy.get(i).i, enemyCopy.get(i).j));
	}
	
	private static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}