// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOHEx66kIDFAWr&categoryId=AWBOHEx66kIDFAWr&categoryType=CODE&problemTitle=%EC%B5%9C%EC%9E%A5&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
package com.swea.course.jul_2025;

/**
 * 3304: 최장 공통 부분 수열(LCS)
 * # summary
 * : 두 문자열 내에서 연속되지 않은 공통의 문자열 중 가장 큰 수를 찾기
 * # access
 * : dp로 풀자! 근데 dp로 풀어도 O(N^2) 같은데.. 일단 풀어보자
 * => 완전 탐색은 O(2^N * 2^M), dp는 O(N*M)
 * # logic
 * @ dp[x][y] = (x까지와 y까지의 최장 공통 문자열 개수)
 *            = (전까지의 최장 공통 문자열 개수) + (현재 x와 y가 같다면 1, 아니면 0)
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3304 {
    public static void main(String args[]) throws IOException {
        long beforeTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] str1 = st.nextToken().toCharArray();
            char[] str2 = st.nextToken().toCharArray();
            int length1 = str1.length;
            int length2 = str2.length;

            int[][] dp = new int[length1 + 1][length2 + 1];
            for (int x = 1; x <= length1; x++) {
                for(int y = 1; y <= length2; y++) {
                    if (str1[x - 1] == str2[y - 1]) {
                        dp[x][y] = dp[x - 1][y - 1] + 1;
                    } else {
                        dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
                    }
                }
            }

            System.out.printf("#%d %d\n", t, dp[length1][length2]);
        }

        long afterTime = System.currentTimeMillis();
        long diffTime = afterTime - beforeTime;
        System.out.println("실행 시간(ms): " + diffTime);
    }
}