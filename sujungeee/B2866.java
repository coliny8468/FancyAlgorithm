
// https://www.acmicpc.net/problem/2866
package com.baekjoon.aug_2025;

/**
 * 2866: 문자열 잘라내기
 * # summary
 * : 맨 위 행을 지워서 나온 열들의 문자열이 중복되지 않는다면 count +1 하여, count 구하기
 * # access
 * : 행 문자열을 열 문자열로 바꾼 후, 같은 중복 문자열이 존재하기 전의 인덱스를 출력해야 한다.
 *  => 단, 완전 탐색은 O(R*C*C) 이므로 이분 탐색 진행!
 * # logic
 * 1. 행 문자열을 열 문자열로 바꾸어 arr에 저장한다.
 * 2. 이분 탐색을 진행한다.
 *     2-1. mid로부터의 부분 문자열들이,
 *          즉 (mid - 1)의 행이 지워졌다 가정했을 때 그 다음 행부터의 모든 열의 문자열들이
 *          => 중복되었다면 dup을 true로 지정한다.
 *     2-2. 만약 중복되었다면 탐색 지점이 왼쪽이기 때문에 right를 (mid - 1)로 갱신하고,
 *          중복되지 않았다면 탐색 지점은 오른쪽이기 때문에 left를 (mid + 1)로 갱신하며, mid 값을 answer로 갱신한다.
 *          (mid 값은 중복되지 않은 count의 최댓값으로 수렴한다. 따라서 answer!)
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class B2866 {
    static int answer;
    static int R, C;
    static StringBuilder[] arr;
    static Set<String> partials;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 1
        arr = new StringBuilder[C];
        for(int i = 0; i < C; i++) arr[i] = new StringBuilder();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[j].append(str.charAt(j));
            }
        }

        // 2
        int left = 0;
        int right = R - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            // 2-1
            partials = new HashSet<>();
            boolean dup = false;
            for (int i = 0; i < C; i++) {
                String sub = arr[i].substring(mid);
                if (partials.contains(sub)) {
                    dup = true;
                    break;
                } else {
                    partials.add(sub);
                }
            }

            // 2-2
            if (dup) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}