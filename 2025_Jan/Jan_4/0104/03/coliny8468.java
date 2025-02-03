
import java.util.*;

public class Main {

    static int n;
    static long x;

    static long totalLayer[];
    static long p[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextLong();

        totalLayer = new long[n + 1];
        p = new long[n + 1];

        totalLayer[0] = 1;
        p[0] = 1;


        for (int i = 1; i <= n; i++) {
            totalLayer[i] = totalLayer[i - 1] * 2 + 3;
            p[i] = p[i-1] * 2 + 1;
        }


        System.out.println(count(n, x));


    }

    static long count(int n, long x) {
        if (n == 0) {
            return 1;
        }

        if (x == 1) {
            return 0;
        }

        if (totalLayer[n - 1] + 1 >= x) {
            return count(n - 1, x - 1);
        } else if (totalLayer[n - 1] + 2 == x) {
            return p[n - 1] + 1;
        } else {
            return p[n - 1] + 1 + count(n - 1, x - totalLayer[n - 1] - 2);
        }
    }
}
