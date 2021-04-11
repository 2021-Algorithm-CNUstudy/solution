package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int nk = n - k;

        int answer = factorial(n) / (factorial(k) * factorial(nk));
        System.out.print(answer);
    }

    public static int factorial(int x) {
        int answer = 1;
        for (int i = x; i > 0; i--) {
            answer *= i;
        }
        return answer;
    }
}
