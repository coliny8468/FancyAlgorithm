import java.io.*;
import java.util.*;

public class B10830 {
    static int[][] init;
    static int N;
    static Long B;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1
        init = new int[N][N];
        for (int i = 0; i < N; i++) init[i][i] = 1;

        // 2
        int[][] result = new int[N][N];
        result = power(B);

        // 4
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] % 1000);
                if (j != N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // 3
    static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(result[i], 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += ((m1[i][k] % 1000) * (m2[k][j] % 1000)) % 1000;
                }
                result[i][j] = sum % 1000;
            }
        }
        return result;
    }

    // 2
    static int[][] power(long num) {
        // 2-1
        if (num == 1) {
            return arr;
        } else if (num == 0) {
            return init;
        }
        // 2-2
        int[][] half = power(num / 2);

        // 2-3
        int[][] square = multiply(half, half);
        // 2-4
        if (num % 2 == 0) {
            return square;
        } else {
            return multiply(square, arr);
        }
    }
}