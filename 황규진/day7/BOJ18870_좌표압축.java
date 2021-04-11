package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Number> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Number(Integer.parseInt(st.nextToken()), i));
		}
		Collections.sort(list, new Comparator<Number>() {
			@Override
			public int compare(Number n1, Number n2) {
				if (n1.num < n2.num) {
					return -1;
				} else if (n1.num > n2.num) {
					return 1;
				}
				return 0;
			}
		});
		int count = 0;
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i).num == list.get(i + 1).num) {
				list.set(i, new Number(i - count, list.get(i).order));
				count++;
			} else {
				list.set(i, new Number(i - count, list.get(i).order));
			}
		}
		list.set(list.size()-1, new Number(list.size() - 1 - count, list.get(list.size()-1).order));
		Collections.sort(list, new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				if (o1.order < o2.order) {
					return -1;
				} else if (o1.order > o2.order) {
					return 1;
				}
				return 0;
			}
		});
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).num);
			if(i != list.size()-1)
				System.out.print(" ");
		}
	}

}

class Number {
	int num;
	int order;

	Number(int num, int order) {
		this.num = num;
		this.order = order;
	}
}