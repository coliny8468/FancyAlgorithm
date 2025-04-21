import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class nuyhus {

    static class Node implements Comparable<Node> {
        int num;
        int start;
        int end;

        Node(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        PriorityQueue<Integer> endTimePQ = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            if (!endTimePQ.isEmpty() && endTimePQ.peek() <= cur.start) {
                endTimePQ.remove();
            }
            endTimePQ.add(cur.end);
        }

        System.out.println(endTimePQ.size());
    }
}
