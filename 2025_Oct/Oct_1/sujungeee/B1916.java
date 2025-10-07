import java.io.*;
import java.util.*;

public class B1916 {
    static int N, M, start, end;
    static List<List<int[]>> graph;
    static int[] distance;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[] {v, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 1
        distance = new int[N + 1];
        Arrays.fill(distance, 1_000_000_000);

        dijkstra();

        // 3
        System.out.println(distance[end]);
    }

    // 2
    public static void dijkstra() {
        // 2-1
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.add(new int[] {start, 0});
        distance[start] = 0;

        while (!queue.isEmpty()) {
            // 2-2
            int[] info = queue.poll();
            int node = info[0];
            int cost = info[1];

            // 2-3
            if (cost > distance[node]) continue;

            for (int[] adj : graph.get(node)) {
                int newNode = adj[0];
                int newCost = cost + adj[1];
                // 2-4
                if (newCost < distance[newNode]) {
                    distance[newNode] = newCost;
                    queue.add(new int[] {newNode, newCost});
                }
            }
        }
    }
}