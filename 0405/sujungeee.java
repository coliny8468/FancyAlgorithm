// https://www.acmicpc.net/problem/4811
// 4811: 알약
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sujungeee {
    public static int N;
    public static int answer;
    public static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            answer = 0;
            dp = new long[N+1][N+1];

            System.out.println(branch(N, 0));
        }
    }

    // remainingOne: 남아있는 한 알의 개수
    // remainingHalf: 남아있는 반 알의 개수
    public static long branch(int remainingOne, int remainingHalf) {
        if (remainingOne == 0 && remainingHalf == 0) {
            return 1;
        }

        if (dp[remainingOne][remainingHalf] != 0) {
            return dp[remainingOne][remainingHalf];
        }

        long result = 0;

        if (remainingOne > 0) { // 하나를 쪼개는 경우
            result += branch(remainingOne - 1, remainingHalf + 1);
        }

        if (remainingHalf > 0) { // 반 개를 먹는 경우
            result += branch(remainingOne, remainingHalf - 1);
        }

        dp[remainingOne][remainingHalf] = result;
        return result;
    }
}