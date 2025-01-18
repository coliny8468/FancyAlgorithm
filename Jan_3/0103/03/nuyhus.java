import java.util.*;
import java.io.*;

public class nuyhus {

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int targetParent = find(1);
        for (int i = 2; i < n + 1; i++) {
            if (targetParent != find(i)) {
                System.out.println("1" + " " + i);
                break;
            }
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                parents[b] = a;
            } else {
                parents[a] = b;
            }
        }
    }

    static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}