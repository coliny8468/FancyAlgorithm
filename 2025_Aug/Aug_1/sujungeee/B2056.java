// https://www.acmicpc.net/problem/2056
package com.baekjoon.aug_2025;

/**
 * 2056: 작업
 * # summary
 * : 모든 작업을 끝내는 최소 시간을 구하자.
 * # access
 * 1. dp
 *     1-1. 현재 작업에 대해서 먼저 수행되어야 할 작업의 시간을 고려해야 하기 때문
 *     1-2. dp[i]: i번째 작업을 마치기까지의 최소 시간
 * # logic
 * 1. 모든 작업은 최소 본인의 수행 시간을 갖는다.
 *    (선행 작업이 없는 작업은 본인의 수행 시간만 실행하면 되기 때문이다.)
 * 2. (본인의 선행 관계에 있는 작업의 시간과 본인의 작업 시간을 더한 값)이 기존 최소 수행 시간보다 크면,
 *    더한 값으로 갱신한다.
 * 3. 모든 작업이 수행 완료되어야 하므로 가장 오래 걸리는 수행 시간을 answer로 할당한다.(using max값 비교)
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2056 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            // 1
            dp[i] = time;
            // 2
            for (int j = 0; j < count; j++) {
                int idx = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i], dp[idx] + time);
            }
            // 3
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}