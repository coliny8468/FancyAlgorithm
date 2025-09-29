import java.io.*;
import java.util.*;

public class B11578 {
    public static int N, M;
    public static List<Integer>[] arr;
    public static int answer;

    public static void main(String[] args) throws IOException {
        answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            arr[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= cnt; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 1
        int total = 1 << M;
        for (int i = 1; i < total; i++) {
            Set<Integer> set = new HashSet<>();
            int cnt = 0;
            // 2
            for (int j = 0; j < M; j++) {
                if ((i & (1 << j)) != 0) {
                    cnt++;
                    set.addAll(arr[j]);
                }
            }
            // 3
            if (set.size() == N) {
                answer = Math.min(answer, cnt);
            }
        }

        // 4
        answer = (answer != Integer.MAX_VALUE) ? answer : -1;
        System.out.println(answer);
    }
}