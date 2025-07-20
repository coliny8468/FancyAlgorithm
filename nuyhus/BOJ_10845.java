import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                int l = Integer.parseInt(st.nextToken());
                q.offer(l);
            } else if (str.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else if (str.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (str.equals("empty")) {
                sb.append(q.isEmpty() ? "1\n" : "0\n");
            } else if (str.equals("front")) {
                sb.append(q.isEmpty() ? "-1\n" : q.peekFirst() + "\n");
            } else if (str.equals("back")) {
                sb.append(q.isEmpty() ? "-1\n" : q.peekLast() + "\n");
            }
        }

        System.out.print(sb);
    }
}
