// https://www.acmicpc.net/problem/2741
// 2741: N 찍기
package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2741 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1 ; i <= N; i++) {
            System.out.println(i);
        }
    }
}