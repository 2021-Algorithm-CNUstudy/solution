package problem_10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Member[] list = new Member[n];
		
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list[i] = new Member(age, name);
		}
		
		Arrays.sort(list, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age == o2.age) {
					return 0;
				}
				return o1.age - o2.age;
			}
		});
		
		for (int i = 0; i < n; ++i)
			bw.write(list[i].age + " " + list[i].name + "\n");
		
		br.close();
		bw.close();
	}
}

class Member {
	int age;
	String name;
	
	Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
}