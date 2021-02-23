package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = 256;
        int max = 0;

        int[][] list = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                list[i][j] = input;

                if (min > input)
                    min = input;
                if (max < input)
                    max = input;
            }
        }

        int second = 9999;
        int floor = 0;
        int blocks;

        check:
        for (int i = min; i <= max; i++) {
            int time = 0;
            blocks = b;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int temp = list[j][k] - i;
                    if (temp > 0) {
                        time += (temp * 2);
                        blocks++;
                    } else if (temp < 0) {
                        time += (temp * -1);
                        blocks--;
                    }

                    if (blocks < 0)
                        break check;
                }
            }

            if (second > time) {
                second = time;
                floor = i;
            }
        }

        System.out.println(second + " " + floor);
    }
}
