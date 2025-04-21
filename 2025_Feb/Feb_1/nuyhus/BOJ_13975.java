import java.util.*;
import java.io.*;

public class BOJ_13975 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> q = new PriorityQueue<>();
            for (int j = 0; j < k; j++) {
                q.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (q.size() > 1) {
                long a = q.remove();
                long b = q.remove();
                long temp = a + b;
                sum += temp;
                q.add(temp);
            }
            System.out.println(sum);
        }
    }
}