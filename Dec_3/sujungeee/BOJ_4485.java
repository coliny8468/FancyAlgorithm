// https://www.acmicpc.net/problem/4485
// 4485: 녹색 옷 입은 애가 젤다지?
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_4485 {
    static int num= 1;
    static int N;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx= {0, 0, 1, -1};
    static int[] dy= {1, -1, 0, 0};
    static int answer;

    public static class Node implements Comparable<Node> {
        int distance;
        int x;
        int y;

        Node(int distance, int x, int y) {
            this.distance= distance;
            this.x= x;
            this.y= y;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());
        while (N != 0) {
            answer= Integer.MAX_VALUE;

            maps= new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    maps[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            dijkstra(N);

            System.out.printf("Problem %d: %d\n", num, answer);
            num++;
            N= Integer.parseInt(br.readLine());
        }
    }

    public static void dijkstra(int N) {
        visited= new boolean[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], false);
        }

        PriorityQueue<Node> heapq= new PriorityQueue<>();
        visited[0][0]= true;
        heapq.add(new Node(maps[0][0], 0, 0));

        while (!heapq.isEmpty()) {
            Node cur= heapq.remove();

            if (cur.x == N-1 && cur.y == N-1) {
                answer= cur.distance;
                return;
            }

            for (int i=0; i<4; i++) {
                int newx= cur.x + dx[i];
                int newy= cur.y + dy[i];

                if (newx < 0 || newx >= N || newy < 0 || newy >= N || visited[newx][newy]) continue;

                visited[newx][newy]= true;
                heapq.add(new Node(cur.distance + maps[newx][newy], newx, newy));
            }
        }
    }
}
