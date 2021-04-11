package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927_최소힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> prq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(prq.isEmpty()) {
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
