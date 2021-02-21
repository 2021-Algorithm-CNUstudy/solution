package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int b = scan.nextInt();

        int[][] list = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                list[i][j] = scan.nextInt();
        }

//        https://www.acmicpc.net/problem/18111 각 값의 평균을 정하여 평균치보다 작은 값을 할지 높은 값을 할지 판단하자.
    }
}
