package problem_10761;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			ArrayList<String> robotList = new ArrayList<>();
			ArrayList<Integer> orangeButtonList = new ArrayList<>();
			ArrayList<Integer> blueButtonList = new ArrayList<>();
			
			for (int i = 0; i < n; ++i) {
				String robot = st.nextToken();
				robotList.add(robot);
				int button = Integer.parseInt(st.nextToken());
				if (robot.equals("O"))
					orangeButtonList.add(button);
				else if (robot.equals("B"))
					blueButtonList.add(button);
			}
			
			int seconds = 0;
			int oPos = 1, bPos = 1;
			while (orangeButtonList.size() != 0 || blueButtonList.size() != 0) {
				if (orangeButtonList.size() == 0) {
					while (blueButtonList.size() != 0) {
						int button = blueButtonList.remove(0);
						seconds += (Math.abs(button - bPos) + 1);
						bPos = button;
					}
				} else if (blueButtonList.size() == 0) {
					while (orangeButtonList.size() != 0) {
						int button = orangeButtonList.remove(0);
						seconds += (Math.abs(button - oPos) + 1);
						oPos = button;
					}
				} else {
					String robot = robotList.remove(0);
					
					int oButton = orangeButtonList.get(0);
					int bButton = blueButtonList.get(0);
					
					int oTime = Math.abs(oButton - oPos);
					int bTime = Math.abs(bButton - bPos);
					
					if (robot.equals("O")) {
						if (oTime >= bTime) {
							seconds += (oTime + 1);
							oPos = oButton;
							bPos = bButton;
						} else if (oTime < bTime) {
							seconds += (oTime + 1);
							oPos = oButton;
							if (bPos > bButton) bPos -= (oTime + 1);
							else if (bPos < bButton) bPos += (oTime + 1);
						}
						orangeButtonList.remove(0);
					} else if (robot.equals("B")) {
						if (oTime <= bTime) {
							seconds += (bTime + 1);
							oPos = oButton;
							bPos = bButton;
						} else if (oTime > bTime) {
							seconds += (bTime + 1);
							bPos = bButton;
							if (oPos > oButton) oPos -= (bTime + 1);
							else if (oPos < oButton) oPos += (bTime + 1);
						}
						blueButtonList.remove(0);
					}
				}
			}
			
			bw.write("#" + test_case + " " + seconds +  "\n");
		}
		br.close();
		bw.close();
	}
}