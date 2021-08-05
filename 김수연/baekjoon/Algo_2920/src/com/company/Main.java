package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] list = new int[8];

        for (int i = 0; i < 8; i++)
            list[i] = scan.nextInt();

        if (list[0] == 1 && list[1] == 2 && list[2] == 3 && list[3] == 4 && list[4] == 5 && list[5] == 6 && list[6] == 7 && list[7] == 8)
            System.out.println("ascending");
        else if (list[0] == 8 && list[1] == 7 && list[2] == 6 && list[3] == 5 && list[4] == 4 && list[5] == 3 && list[6] == 2 && list[7] == 1)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
