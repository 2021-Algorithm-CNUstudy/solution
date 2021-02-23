package com.company;

import java.util.Scanner;

public class Main {
    static int r = 31;
    static int m = 1234567891;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int l = scan.nextInt();
        scan.nextLine();
        String temp = scan.nextLine();

        long answer = 0;

        for (int i = 0; i < l; i++) {
            int a = temp.charAt(i) - 96;
            answer += a * pow(r, i) % m;
        }
        System.out.println(answer % m);
    }

    public static long pow(int x, int y) {
        return y == 0 ? 1 : x * pow(x, y - 1) % m;
    }
}
