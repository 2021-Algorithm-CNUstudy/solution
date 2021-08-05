package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();
        int w = scan.nextInt();
        int h = scan.nextInt();

        int answer1 = x;
        int answer2 = w - x;
        int answer3 = y;
        int answer4 = h - y;
        int answer5, answer6, answer;

        if (answer1 < answer2)
            answer5 = answer1;
        else
            answer5 = answer2;
        if (answer3 < answer4)
            answer6 = answer3;
        else
            answer6 = answer4;
        if (answer5 < answer6)
            answer = answer5;
        else
            answer = answer6;

        System.out.println(answer);
    }
}
