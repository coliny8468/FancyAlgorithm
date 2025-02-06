import java.util.Scanner;

public class BOJ_2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        int count = 0;
        while (count < k) {
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;

            int ans = 0;
            for (int l = i; l <= x; l++) {
                for (int o = j; o <= y; o++) {
                    ans += arr[l][o];
                }
            }

            System.out.println(ans);
            count++;
        }
    }
}
