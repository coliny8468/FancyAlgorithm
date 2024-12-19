import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class nuyhus {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                return;
            }

            ArrayList<Node> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y, w));
                sum += w;
            }

            Collections.sort(list);

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int cost = 0;
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                int a = find(node.start);
                int b = find(node.end);

                if (a != b) {
                    parent[b] = a;
                    cost += node.weight;
                }
            }

            System.out.println(sum - cost);
        }
    }

    static int find(int e) {
        if (e == parent[e]) {
            return e;
        }
        return parent[e] = find(parent[e]);
    }

    static void union(int a, int b) {
        parent[b] = a;
    }
}
