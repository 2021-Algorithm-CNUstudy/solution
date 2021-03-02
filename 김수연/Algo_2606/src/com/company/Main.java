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
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int[][] list = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            list[temp1][temp2] = 1;
            list[temp2][temp1] = 1;
        }

        Queue<Integer> answer = new LinkedList<>();
        ArrayList<Integer> connect = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            if (list[1][i] == 1) {
                answer.add(i);
                connect.add(i);
            }
        }

        while (! answer.isEmpty()) {
            int remove = answer.remove();
            for (int i = 0; i < n + 1; i++) {
                if (list[remove][i] == 1 && (! connect.contains(i))) {
                    answer.add(i);
                    connect.add(i);
                }
            }
        }

        if (connect.contains(1))
            connect.remove((Object) 1);
        System.out.println(connect.size());
    }
}
