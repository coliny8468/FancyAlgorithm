// https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
package com.swea.course.jun_2025;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3282 {
    static int[][] infos;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            dp = new int[N + 1][K + 1];

            // 1
            infos = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                infos[i][0] = Integer.parseInt(st.nextToken());
                infos[i][1] = Integer.parseInt(st.nextToken());
            }

            // 2
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    if (j >= infos[i][0]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - infos[i][0]] + infos[i][1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            System.out.printf("#%d %d\n", testCase, dp[N][K]);
        }
    }
}