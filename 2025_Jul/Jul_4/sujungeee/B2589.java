// https://www.acmicpc.net/problem/2589
package com.baekjoon.jul_2025;

/**
 * 2589: 보물섬
 * # summary
 * : 두 보물 사이를 최단 거리로 갈 수 있는 가장 긴 시간
 * # access
 * 1. bfs로 4방 탐색을 진행하며, 최단 거리로 갈 수 있는 경로들을 탐색
 * 2. 갈 수 있는 경로의 거리 중 가장 긴 값을 갱신 + return하기
 * # logic
 * 1. 지도에서 육지가 존재한다면, 해당 육지를 시작점으로 갈 수 있는 육지들을 탐색한다.
 * 2. bfs
 *     2-1. 시작점은 방문 처리하고, queue에 추가한다.
 *     2-2. 시작점으로부터 갈 수 있는 곳을 방문 처리하고, queue에 추가한다. (범위 내이며 / 방문한적이 없으며 / 육지인 곳)
 *     2-3. 갈 수 있는 곳이 가장 긴 시간(time)이면 answer를 갱신한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class B2589 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 , 0};
    static int N, M;
    static char[][] map;
    static ArrayDeque<Info> queue;
    static int answer;

    static class Info {
        int x, y, time;

        Info(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    // 2
    static void bfs(int x, int y) {
        // 2-1
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        queue = new ArrayDeque<>();
        queue.addLast(new Info(x, y, 0));

        while (!queue.isEmpty()) {
            Info info = queue.pollFirst();
            // 2-3
            answer = Math.max(info.time, answer);

            // 2-2
            for (int i = 0; i < 4; i++) {
                int newX = info.x + dx[i];
                int newY = info.y + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
                if (map[newX][newY] == 'W' || visited[newX][newY]) continue;

                visited[newX][newY] = true;
                queue.addLast(new Info(newX, newY, info.time + 1));
            }
        }
    }
}