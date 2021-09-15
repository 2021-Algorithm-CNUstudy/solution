package problem_1197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public class Main {
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> edges = new ArrayList<>();
		for (int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(start, end, cost));
		}
		
		edges.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return Integer.compare(e1.c, e2.c);
			}
		});
		
		parents = new int[v + 1];
		for (int i = 0; i <= v; ++i)
			parents[i] = i;
		
		int answer = 0;
		for (int i = 0; i < e; ++i) {
			Edge edge = edges.get(i);
			if (! isSameParent(edge.s, edge.e)) {
				union(edge.s, edge.e);
				answer += edge.c;
			}
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int find(int x) {
		if (parents[x] == x)
			return x;
		return find(parents[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y)
			parents[x] = y;
	}
	
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }
}

class Edge {
	int s, e, c;
	
	public Edge(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
}