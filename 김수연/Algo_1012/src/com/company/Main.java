package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static int[][] list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            n = Integer.parseInt(st.nextToken()); // 세로길이
            int k = Integer.parseInt(st.nextToken()); // 배추 개수
            answer = 0; // 지렁이 수

            list = new int[n][m];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++)
                    list[x][y] = 0; // 다 0 으로 초기화
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추의 x좌표
                int y = Integer.parseInt(st.nextToken()); // 배추의 y좌표
                list[y][x] = 1; // 배추 심기
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if(list[x][y] == 1) { // 배추가 있다.
                        //그럼 주변에 다른 배추 확인해보기.
                        find(x, y);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void find(int x, int y) {
        list[x][y] = 2;
        for(int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx >= 0 && xx < n && yy >= 0 && yy < m && list[xx][yy] == 1)
                find(xx, yy);
        }
        return;
    }
}
