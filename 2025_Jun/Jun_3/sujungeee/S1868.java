// // https://swexpertacademy.com/main/code/problem/problemDetail.do
import java.io.*;
import java.util.*;

public class S1868 {
    static int N;
    static char[][] map;

    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
    static boolean[][] visited;

    public static int solution() {
        int answer = 0;
        visited = new boolean[N][N];

        // 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0; // 주변의 지뢰 개수

                for (int k = 0; k < 8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];

                    if (newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                    if (map[newX][newY] == '*') cnt++;
                }
                if (map[i][j] != '*') {
                    map[i][j] = (char) (cnt + '0');
                }
            }
        }

        // 2
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == '0') {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        // 3
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != '*') {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] coord = queue.pollFirst();
            int x = coord[0];
            int y = coord[1];

            for (int k = 0; k < 8; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                if (!visited[newX][newY]) {
                    if (map[x][y] == '0' && map[newX][newY] != '*') {
                        visited[newX][newY] = true;
                        queue.addLast(new int[] {newX, newY});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            System.out.printf("#%d %d\n", testCase, solution());
        }
    }
}