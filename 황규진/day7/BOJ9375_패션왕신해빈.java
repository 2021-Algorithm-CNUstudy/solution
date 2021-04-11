package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ9375_패션왕신해빈 {
	static int result;
	static Cloth[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//각 옷에 대해서 재귀를 들어가는 방향으로 짜보자
		//재귀 들어가는 순간, 카운트 +1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			list = new Cloth[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new Cloth(st.nextToken(), st.nextToken());
			}
			result = 0;
			for (int i = 0; i < n; i++) {
				HashMap<String, Boolean> map = new HashMap<>();
				map.put(list[i].type, true);
				dfs(map, i, 1);
			}
			System.out.println(result);
		}
	}
	private static void dfs(HashMap map, int index, int sum) {
		boolean check = false;
		for (int i = index; i < list.length; i++) {
			// 여태까지 골라온 타입을 저장해두는게 필요하다.
			if(!map.containsKey(list[i].type)) {
				sum = sum*2;
				map.put(list[i].type, true);
				check = true;
				dfs(map, i, sum);
			} else {
				
			}
		}
		if(!check)
			result += sum;
	}
}
class Cloth {
	String name;
	String type;
	Cloth(String name, String type) {
		this.name = name;
		this.type = type;
	}
}