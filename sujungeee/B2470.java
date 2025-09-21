import java.util.*;
import java.io.*;

public class B2470 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int minAnswer = 0;
        int maxAnswer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 1
        Arrays.sort(arr);

        // 2
        Long value = 2_000_000_000L;
        int p1 = 0;
        int p2 = N - 1;

        // 3
        while (p1 < p2) {
            Long sum = (long) arr[p1] + arr[p2];

            // 3-1
            if (Math.abs(sum) <= Math.abs(value)) {
                value = sum;
                minAnswer = arr[p1];
                maxAnswer = arr[p2];
            }

            // 3-2
            if (sum > 0) p2--;
            else p1++;
        }

        System.out.println(minAnswer + " " + maxAnswer);
    }
}