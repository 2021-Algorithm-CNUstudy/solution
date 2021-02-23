package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputI = scan.nextInt();
        while (inputI != 0) {
            String inputS = Integer.toString(inputI);
            String reverseS = new StringBuffer(inputS).reverse().toString();
            int reverseI = Integer.parseInt(reverseS);

            if (inputI == reverseI)
                System.out.println("yes");
            else
                System.out.println("no");

            inputI = scan.nextInt();
        }
    }
}
