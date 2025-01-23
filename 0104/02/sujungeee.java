// https://www.acmicpc.net/problem/2877
// 2877: 4와 7
package com.baekjoon.jan_2025;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sujungeee {
    public static int k;
    public static int digit, idx;
    public static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        k= Integer.parseInt(br.readLine());

        digit= 0; // // k번째로 작은 수(answer)의 자릿수
        int sum= 0;
        while(sum < k) {
            digit++;
            sum= (int) (sum + Math.pow(2, digit));
        }
        idx= (int) ((k - (sum - Math.pow(2, digit))) - 1); // 4와 7로 이루어짐 + digit 자릿수로 구성된 숫자들에서의 k' 인덱스

        // idx를 2진수로 변환
        answer= Integer.toBinaryString(idx);

        // 2진수를 4와 7로 이루어진 숫자로 포매팅
        answer= String.format("%" + digit + "s", answer).replace(' ', '0');
        answer= answer.replace("0", "4")
                .replace("1", "7");

        System.out.println(answer);
    }
}