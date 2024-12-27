import java.io.*;
import java.util.*;

public class BOJ_11509 {

    static int[] arr = new int[1_000_001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (arr[h] > 0) {
                arr[h]--;
            }
            arr[h - 1]++;
        }

        int ans = 0;
        for (int i : arr) {
            ans += i;
        }

        System.out.println(ans);
    }
}