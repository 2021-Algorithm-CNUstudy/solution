package Practice;

import java.util.*;

public class Main {
	public static int N, M;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int channel = input.nextInt();
		int number = input.nextInt();
		HashSet<Integer> canUse = new HashSet<>();
		if (number != 0) {
			for (int i = 0; i <= 9; i++) {
				canUse.add(i);
			}
			for(int i = 0; i < number; i++) {
				canUse.remove(input.nextInt());
			}
			int min = Math.abs(channel - 100); // +나 -만 이용하는 경우
			int check = 0;
			while(check < 1000001) {
				String str = String.valueOf(check);
				for(int i = 0; i < str.length(); i++) {
					if(!canUse.contains(Integer.parseInt(str.charAt(i) + ""))) {
						break;
					}
					else if(i == str.length() - 1) {
						min = Math.min(min, Math.abs(channel - check) + str.length());
					}
				}
				check++;
			}
			System.out.println(min);
		}
		else {
			int min = Math.min(Math.abs(channel - 100), String.valueOf(channel).length());
			System.out.println(min);
		}
	}
}
