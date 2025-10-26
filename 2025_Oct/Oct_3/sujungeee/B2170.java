import java.io.*;
import java.util.*;

public class B2170 {
    static int N;
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        long length = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1
        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        // 2
        long start = arr[0][0];
        long end = arr[0][1];
        for (int i = 1; i < N; i++) {
            // 3
            if (arr[i][0] <= end) {
                end = Math.max(arr[i][1], end);
            } else { // 4
                length += (end - start);
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        // 5
        length += (end - start);
        System.out.println(length);
    }
}