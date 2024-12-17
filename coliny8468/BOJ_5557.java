
import java.util.*;

public class Main {

    static int n;
    static int[] nums;
    static long[][] dp;  // dp[cnt][result]를 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];
        dp = new long[n][21];  // n개의 숫자, 결과 값은 0부터 20까지 가능

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 초기 상태 설정: 첫 번째 숫자에서 시작
        dp[0][nums[0]] = 1;

        // DP 계산
        for (int cnt = 1; cnt < n - 1; cnt++) {
            for (int result = 0; result <= 20; result++) {
                if (dp[cnt - 1][result] > 0) {  // 이전 상태에서 결과 값이 있을 때
                    int add = result + nums[cnt];
                    int subtract = result - nums[cnt];

                    // 더하는 경우, 결과가 20 이하이면
                    if (add <= 20) {
                        dp[cnt][add] += dp[cnt - 1][result];
                    }

                    // 빼는 경우, 결과가 0 이상이면
                    if (subtract >= 0) {
                        dp[cnt][subtract] += dp[cnt - 1][result];
                    }
                }
            }
        }

        // 마지막 숫자에서 원하는 결과가 나오는 경우의 수 출력
        System.out.println(dp[n - 2][nums[n - 1]]);
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;

public class Main {

    static int n;
    static int[] nums;
    static long[][] dp;  // dp[cnt][result]를 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];
        dp = new long[n][21];  // n개의 숫자, 결과 값은 0부터 20까지 가능

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 초기 상태 설정: 첫 번째 숫자에서 시작
        dp[0][nums[0]] = 1;

        // DP 계산
        for (int cnt = 1; cnt < n - 1; cnt++) {
            for (int result = 0; result <= 20; result++) {
                if (dp[cnt - 1][result] > 0) {  // 이전 상태에서 결과 값이 있을 때
                    int add = result + nums[cnt];
                    int subtract = result - nums[cnt];

                    // 더하는 경우, 결과가 20 이하이면
                    if (add <= 20) {
                        dp[cnt][add] += dp[cnt - 1][result];
                    }

                    // 빼는 경우, 결과가 0 이상이면
                    if (subtract >= 0) {
                        dp[cnt][subtract] += dp[cnt - 1][result];
                    }
                }
            }
        }

        // 마지막 숫자에서 원하는 결과가 나오는 경우의 수 출력
        System.out.println(dp[n - 2][nums[n - 1]]);
    }
}

