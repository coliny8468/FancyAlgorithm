import java.io.*;
import java.util.*;

public class B13397 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1
        int minValue = Integer.MAX_VALUE;
        int maxValue = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i]);
        }
        int left = 0;
        int right = maxValue - minValue;

        // 2
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    // 3
    public static boolean possible(int value) {
        // 3-1
        int cnt = 1;
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int i = 0; i < N; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i]);
            // 3-2
            if (maxValue - minValue > value) {
                cnt++;
                minValue = arr[i];
                maxValue = arr[i];
            }
        }

        // 3-3
        return cnt <= M;
    }
}