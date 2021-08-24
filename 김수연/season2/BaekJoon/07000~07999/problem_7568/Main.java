package problem_7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Person[] list = new Person[n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == j) continue;
				if (list[i].x < list[j].x && list[i].y < list[j].y)
					++list[i].level;
			}
			bw.write(list[i].level + "\n");
		}
		
		
		br.close();
		bw.close();
	}
}

class Person {
	int x, y, level;
	
	Person(int x, int y) {
		this.x = x;
		this.y = y;
		this.level = 1;
	}
}