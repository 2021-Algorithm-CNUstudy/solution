package com.company;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            list[i][0] = scan.nextInt();
            list[i][1] = scan.nextInt();
        }

        Arrays.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++)
            System.out.println(list[i][0] + " " + list[i][1]);
    }
}
