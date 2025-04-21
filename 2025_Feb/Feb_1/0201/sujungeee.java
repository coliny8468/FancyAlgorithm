// https://www.acmicpc.net/problem/2234
// 2234: 성곽
package com.baekjoon.feb_2025;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class sujungeee {
    public static int[] dx = {1, 0, -1, 0}; // 남 동 북 서
    public static int[] dy = {0, 1, 0, -1};
    public static int answer1, answer2, answer3;
    public static int N, M;
    public static String[][] map;
    public static int[][] visited;
    public static ArrayDeque<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = String
                        .format("%4s", Integer.toBinaryString(value))
                        .replace(' ', '0');
            }
        }

        solution1();
        solution2();
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }

    public static void solution1() {
        visited = new int[M][N];
        answer1 = 0;
        answer2 = 0;
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    bfs1(i, j);
                    answer1++;
                }
            }
        }
    }

    public static void bfs1(int a, int b) {
        int area= 1;
        queue = new ArrayDeque<>();
        queue.addLast(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] xy = queue.pollFirst();
            int x = xy[0];
            int y = xy[1];
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                if (map[x][y].charAt(i) == '1') continue;

                int newx = x + dx[i];
                int newy = y + dy[i];
                if (0 > newx || newx >= M || 0 > newy || newy >= N) continue;

                if (visited[newx][newy] == 0) {
                    queue.addLast(new int[] {newx, newy});
                    area++;
                }
            }
        }
        answer2 = Math.max(area, answer2);
    }

    public static void solution2() {
        visited = new int[M][N];
        answer3 = 0;
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    bfs2(i, j);
                }
            }
        }
    }

    public static void bfs2(int a, int b) {
        boolean flag = false;
        queue = new ArrayDeque<>();
        queue.addLast(new int[]{a, b, 0});

        while (!queue.isEmpty()) {
            int[] info = queue.pollFirst();
            int x = info[0];
            int y = info[1];
            int area = info[2];
            answer3 = Math.max(answer3, area);
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (0 > newx || newx >= M || 0 > newy || newy >= N) continue;

                if (visited[newx][newy] == 0) {
                    if(map[x][y].charAt(i) != '1') {
                        queue.addLast(new int[] {newx, newy});
                        area++;
                    } else {
                        if (!flag) {
                            flag = true;
                            queue.addLast(new int[] {newx, newy});
                            area++;
                        }
                    }
                }
            }
        }
    }
}