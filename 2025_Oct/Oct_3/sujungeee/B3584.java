import java.io.*;
import java.util.*;

public class B3584 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // 1
            int answer = 0;
            Set<Integer> parents1 = new HashSet<>();
            Set<Integer> parents2 = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                arr[child] = parent;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 2
            parents1.add(node1);
            parents2.add(node2);

            while (true) {
                // 3
                if (parents1.contains(node2)) {
                    answer = node2;
                    break;
                }
                if (parents2.contains(node1)) {
                    answer = node1;
                    break;
                }
                // 4
                node1 = arr[node1];
                node2 = arr[node2];
                parents1.add(node1);
                parents2.add(node2);
            }

            System.out.println(answer);
        }
    }
}