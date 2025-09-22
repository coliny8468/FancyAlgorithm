import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5582 {
	public static void main(String[] args) throws IOException {
        int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int N = str1.length();
		int M = str2.length();

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					// 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
				} else {
                	// 2
					dp[i][j] = 0;
				}
			}
		}

        // 3
		System.out.println(answer);
	}
}