package problem_17143;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Shark> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new LinkedList<>();
		
		for (int index = 0; index < m; ++index) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			list.add(new Shark(i, j, s, d, z));
		}
		
		
		int score = 0;
		int angler = -1;
		
		int[] di = {-1, 1, 0, 0};
		int[] dj = {0, 0, 1, -1};
		
		while (angler != c) {
			++angler;
			
			sort();
			for (int index = 0; index < list.size(); ++index) {
				Shark shark = list.get(index);
				
				if (shark.j != angler)
					continue;
				
				score += shark.z;
				list.remove(index);
				break;
			}

			for (int index = 0; index < list.size(); ++index) {
				Shark shark = list.remove(0);
				
				int ni = shark.i;
				int nj = shark.j;
				int s = shark.s;
				int d = shark.d;
				
				if (d == 0 || d == 1) {
					s &= 2 * r - 2;
					for (int i = 0; i < s; ++i) {
						if (ni == 0)
							d = 1;
						else if (ni == r - 1)
							d = 0;
						ni += di[d];
					}
				} else if (d == 2 || d == 3) {
					s &= 2 * c - 2;
					for (int i = 0; i < s; ++i) {
						if (nj == 0)
							d = 2;
						else if (nj == c - 1)
							d = 3;
						nj += dj[d];
					}
				}
				
				list.add(new Shark(ni, nj, shark.s, d, shark.z));
			}
			
			// 겹치는 상어 제거
			loop: for (int index = list.size() - 1; index >= 0; --index) {
				for (int index2 = index - 1; index2 >= 0; --index2) {
					Shark s = list.get(index);
					Shark s2 = list.get(index2);
					
					if (s.i == s2.i && s.j == s2.j) {
						if (s.z > s2.z)
							list.remove(index2);
						else if (s.z < s2.z)
							list.remove(index);
						
						continue loop;
					}
				}
			}
		}
		
		bw.write(score + "\n");
		
		br.close();
		bw.close();
	}
	
	private static void sort() {
		Collections.sort(list, new Comparator<Shark>() {
			@Override
			public int compare(Shark o1, Shark o2) {
				return o1.i - o2.i;
			}
		});
	}
}

class Shark {
	int i, j, s, d, z;
	
	Shark(int i, int j, int s, int d, int z) {
		this.i = i;
		this.j = j;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}