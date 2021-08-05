package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> list = new LinkedList<>();
        ArrayList<Integer> checkList = new ArrayList<>();
        list.add(n);
        checkList.add(n);

        boolean answer = false;
        if (n == k)
            answer = true;
        int time = 0;
        int checkNumber = n - 1;

        while (! answer) {
            int temp = list.remove();

            int add1 = temp - 1;
            int add2 = temp + 1;
            int add3 = temp * 2;

            if (checkNumber == add1) {
                checkNumber--;
                time++;
            }

            if (add1 == k || add2 == k || add3 == k)
                answer = true;
            else {
                if (! checkList.contains(add1)) {
                    list.add(add1);
                    checkList.add(add1);
                }
                if (! checkList.contains(add2)) {
                    list.add(add2);
                    checkList.add(add2);
                }
                if (! checkList.contains(add3)) {
                    list.add(add3);
                    checkList.add(add3);
                }
            }
        }

        System.out.println(time);
    }
}
