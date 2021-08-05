package problem_1244;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] list = new int[n + 1];
		
		for (int i = 1; i <= n; i++)
			list[i] = scan.nextInt();
		
		int students = scan.nextInt();
		for (int i = 0; i < students; i++) {
			int sex = scan.nextInt();
			int num = scan.nextInt();
			int temp = num;
			
			if (sex == 1) {	// 남학생
				while (num <= n) {
					list[num] = 1 - list[num];
					num += temp;
				}
			} else {		// 여학생
				int down = num - 1;
				int up = num + 1;
				list[num] = 1 - list[num];
				while (down > 0 && up <= n) {
					if (list[down] != list[up]) {
						break;
					}
					else {
						list[down] = 1 - list[down];
						list[up] = 1 - list[up];
					}
					down--;
					up++;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(list[i]);
			if (i % 20 == 0)
				System.out.println();
			else
				System.out.print(" ");
		}
		
		scan.close();
	}
}