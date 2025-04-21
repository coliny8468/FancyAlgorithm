// https://www.acmicpc.net/problem/27433
// 27433: 팩토리얼 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27433 {
    public static int N;
    public static long answer;

    public static void main(String[] args) throws IOException {
        answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(1);
        } else {
            for (int i = N ; i > 0; i--) {
                answer *= i;
            }
            System.out.println(answer);
        }
    }
}