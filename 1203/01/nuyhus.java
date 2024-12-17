import java.util.*;
import java.io.*;

public class nuyhus {

    static int n;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    static int MAX = 100000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 0;
        while (true) {
            tc++;

            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = MAX;
                }
            }

            bfs();
            System.out.println("Problem " + tc + ": " + visited[n - 1][n - 1]);

        }

    }


    static void bfs() {

        visited[0][0] = map[0][0];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {

            int[] cur = q.remove();

            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (visited[nx][ny] > visited[cx][cy] + map[nx][ny]) {
                        visited[nx][ny] = visited[cx][cy] + map[nx][ny];
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
