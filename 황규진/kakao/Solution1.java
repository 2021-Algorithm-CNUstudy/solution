package kakao;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] gift_cards = new int[n];
		int[] wants = new int[n];
		for (int i = 0; i < n; i++) {
			gift_cards[i] = sc.nextInt();
		}
		for (int j = 0; j < n; j++) {
			wants[j] = sc.nextInt();			
		}
		int count = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if(gift_cards[i] == wants[i]) {
				visited[i] = true;
			} else {
				for (int j = 0; j < visited.length; j++) {
					if(visited[j] == false && wants[i] == gift_cards[j]) {
						int tmp = gift_cards[i];
						gift_cards[i] = gift_cards[j];
						gift_cards[j] = tmp;
						visited[i] = true;
						if(gift_cards[j] == wants[j]) {
							visited[j] = true;
						}
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
