// https://www.acmicpc.net/problem/13164
package com.baekjoon.aug_2025;

/**
 * 13164: 행복 유치원
 * # summary
 * : 조(K)별 단체 티셔츠의 최소 비용을 구하자!
 * # access
 * 1. K개의 조를 뽑으려면 전체 N명에 (K - 1)개의 구분선을 두어야 한다.
 * => 비용은 구간의 양 끝 값의 차이이므로,
 *    원생들 간의 키 차이들 (N - 1) 중 (K - 1)개을 뽑아야 한다.
 * 2. 최소 비용을 구해야 하므로.. (K - 1)개는 정해져있다!
 *    단연 가장 작은 차이를 갖는 비용을 선택해야 할 것이다.
 * => 따라서 원생들 간의 키 차이들 (N - 1)을 먼저 오름차순 정렬해야 한다.
 * # logic
 * 1. (큰 원생의 키 - 작은 원생의 키)를 모두 diffs에 저장한다.
 * 2. diffs를 오름차순 정렬한다.
 * 3. (N-1)에서 (K-1)개를 뽑아서 answer(구간 별 최소 비용의 합)에 합산한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B13164 {
    static int N, K;
    static int[] arrs;
    static int[] diffs;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1
        arrs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrs[i] = Integer.parseInt(st.nextToken());
        }
        diffs = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = arrs[i + 1] - arrs[i];
        }

        // 2
        Arrays.sort(diffs);

        // 3
        for(int i = 0; i < N - K; i++) {
            answer += diffs[i];
        }

        System.out.println(answer);
    }
}