package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> prq = new PriorityQueue<>((o1, o2) -> Math.abs(o1) == Math.abs(o2)
				? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2)));
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (prq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(prq.poll());
				}
			} else {
				prq.add(input);
			}
		}

	}

}
