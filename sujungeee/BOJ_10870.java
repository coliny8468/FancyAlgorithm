// https://www.acmicpc.net/problem/10870
// 10870: 피보나치 수 5

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10870 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fibonacci(N-1) + fibonacci(N-2);
    }
}
