// https://www.acmicpc.net/problem/11729
package com.baekjoon.aug_2025;

/**
 * 11729: 하노이 탑 이동 순서
 * # summary
 * : 규칙에 맞춰 원판을 모두 세 번째 장대로 옮기기까지의 최소 이동 횟수와 그 과정을 출력하자!
 * # access
 * 1. 스택 이용 + 재귀 이용(장대 순서를 선택함에 있어서) => 전의 순서를 기억하지 못하므로 무한 루프를 돌 수 있다. 탈락!
 * 2. 재귀 (경로 규칙 이용)
 * # logic
 * 1. (N - 1)개를 1에서 3을 거쳐 2로 이동시킨다. (1 → 3 → 2)
 * 2. 원판 N을 3으로 이동시킨다.
 * 3. (N - 1)개를 2에서 1을 거쳐 3으로 이동시킨다. (2 → 1 → 3)
 * 원판을 이동시킬 때는 count를 1 늘리고, 과정을 StringBuilder에 담아 최종 answer로 출력한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11729 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;

        recur(N, 1, 2, 3);

        System.out.println(count);
        System.out.println(sb);
    }

    static void recur(int n, int start, int mid, int end) {
        if (n == 1) {
            count++;
            sb.append(start + " " + end + "\n");
            return;
        }

        // 1
        recur(n - 1, start, end, mid);
        // 2
        sb.append(start + " " + end + "\n");
        count++;
        // 3
        recur(n - 1, mid, start, end);
    }
}