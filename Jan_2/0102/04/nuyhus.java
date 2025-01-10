import java.util.*;
import java.io.*;

public class nuyhus {

    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n <= 10) {
            System.out.println(n - 1);
            return;
        }

        go(0, 0);
        Collections.sort(list);

        if (list.size() >= n) {
            System.out.println(list.get(n - 1));
        } else {
            System.out.println(-1);
        }
    }

    public static void go(long num, int idx) {

        if (!list.contains(num)) {
            list.add(num);
        }

        if (idx == 10) {
            return;
        }

        go(num, idx + 1);
        go(num * 10 + arr[idx], idx + 1);
    }
}
