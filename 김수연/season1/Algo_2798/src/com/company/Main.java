package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = scan.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = list[i] + list[j] + list[k];
                    if (max < temp && m >= temp)
                        max = temp;
                }
            }
        }

        System.out.println(max);
    }
}
