package problem_2056;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i = 0; i < T; i++) {
			int number = scan.nextInt();
			
			int year = number / 10000;
			
			int temp = number - (year * 10000);
			int month = temp / 100;
			
			int day = temp - (month * 100);
			
			String answer;
			if (month < 1 || month > 12 || day < 1 || day > days[month - 1])
				answer = "-1";
			else {
				String year2 = Integer.toString(year);
				String month2 = Integer.toString(month);
				String day2 = Integer.toString(day);
				
				if (year < 1000) {
					year2 = "0" + year2;
					if (year < 100) {
						year2 = "0" + year2;
						if (year < 10)
							year2 = "0" + year2;
					}
				}
				
				if (month < 10)
					month2 = "0" + month2;
				
				if (day < 10)
					day2 = "0" + day2;
				
				answer = year2 + "/" + month2 + "/" + day2;
			}
			
			System.out.println("#" + (i + 1) + " " + answer);
		}
		
		scan.close();
	}
}
