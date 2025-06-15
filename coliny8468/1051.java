import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int map[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = a.charAt(j) - '0';
            }
        }

        int max = Math.min(n,m);

        loop: for (int i = max; i > 0 ; i--) {
            for (int j = 0; j <= n-i; j++) {
                for (int k = 0; k <= m-i; k++) {
                        if (map[j][k] == map[j+i-1][k+i-1]
                                && map[j+i-1][k] == map[j][k]
                                &&map[j][k] == map[j][k+i-1]) {
                            System.out.println(i*i);
                            break loop;
                        }
                }
            }
        }
    }
}
