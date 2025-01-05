import java.io.*;
import java.util.*;

public class BOJ_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int w = 1; w <= k; w++) {
            for (int i = 1; i <= n; i++) {
                dp[i][w] = dp[i - 1][w];
                if (arr[i][0] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], arr[i][1] + dp[i - 1][w - arr[i][0]]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}