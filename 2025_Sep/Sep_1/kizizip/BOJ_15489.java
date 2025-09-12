// 처음 코드

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int r = sc.nextInt();
//         int c = sc.nextInt();
//         int w = sc.nextInt();
//         int length = r + w;

//         int[][] dp = new int[length + 1][length + 1];
//         for (int i = 1; i <= length; i++) {
//             dp[i][1] = 1;
//             dp[i][i] = 1;
//         }

//         for (int i = 2; i <= length; i++) {
//             for (int j = 2; j < i; j++) {
//                 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//             }
//         }

//         int sum = 0;
//         for (int i = 0; i < w; i++) { 
//             for (int j = 0; j <= i; j++) { 
//                 sum += dp[r + i][c + j];
//             }
//         }

//         System.out.println(sum);
//     }
// }


// 변수나 반복문 좀 정리
import java.util.Scanner;

public class BOJ_15489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int w = sc.nextInt();

        int[][] dp = new int[r+w + 1][r+w + 1];
        for (int i = 1; i <= r+w; i++) {
            dp[i][1] = dp[i][i] = 1; //양끝 1 삽입

            for (int j = 2; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }

        }

        int sum = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                sum += dp[r + i][c + j];
            }
        }

        System.out.println(sum);
    }
}
