// https://www.acmicpc.net/problem/1247
// 1247: 부호
package com.baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            BigInteger total = new BigInteger("0");

            for (int j = 0; j < N; j++) {
                total = total.add(new BigInteger(br.readLine()));
            }

            if (total.compareTo(BigInteger.ZERO) == 0) {
                System.out.println("0");
            } else if (total.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("+");
            } else if (total.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("-");
            }
        }
    }
}