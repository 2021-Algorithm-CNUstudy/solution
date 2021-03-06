package Practice;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int [][] coor = new int[N][2];
		for(int i = 0; i < N; i++) {
			coor[i][0] = input.nextInt();
			coor[i][1] = input.nextInt();
		}
		Arrays.sort(coor, new Comparator<int[]>() { // 다차원 배열을 정렬하기 위한 comparator 인터페이스 재정의
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[0] == arr2[0]) {
					return arr1[1] > arr2[1] ? 1 : -1; // 원래 compare 메소드는 -1, 0, 1을 return하므로 이를 똑같이 활용 
				}
				return arr1[0] > arr2[0] ? 1 : -1;
			}
		});
		for(int i = 0; i < N; i++) {
			System.out.println(coor[i][0] + " " + coor[i][1]);
		}
	}
}
