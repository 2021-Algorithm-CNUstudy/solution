package com.company;
// 수 찾기

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] listN = new int[n];
        for (int i = 0; i < n; i++)
            listN[i] = scan.nextInt();
        Arrays.sort(listN);

        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int temp = scan.nextInt();
            if (Arrays.binarySearch(listN, temp) >= 0)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
