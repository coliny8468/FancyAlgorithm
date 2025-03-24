import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13424 {

    static final int INF = 1000000; // 무한대 값

    static int n, m, k;
    static int[][] map;
    static int[] friends;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 방 개수
            m = Integer.parseInt(st.nextToken()); // 통로 개수

            // 최단 거리를 저장할 배열
            map = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (x != y) {
                        map[x][y] = INF;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                map[a][b] = c;
                map[b][a] = c;
            }

            k = Integer.parseInt(br.readLine()); // 친구 수
            friends = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                friends[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            // 최단 거리 계산
            for (int b = 0; b < n; b++) {
                for (int a = 0; a < n; a++) {
                    for (int c = 0; c < n; c++) {
                        if (map[a][b] != INF && map[b][c] != INF) {
                            map[a][c] = Math.min(map[a][c], map[a][b] + map[b][c]);
                        }
                    }
                }
            }

            // 정답 구하기
            int minDist = INF;
            int answer = -1;
            for (int dest = 0; dest < n; dest++) {
                int temp = 0;
                for (int friend : friends) {
                    temp += map[friend][dest];
                }

                if (minDist > temp) {
                    answer = dest;
                    minDist = temp;
                }
            }

            System.out.println(answer + 1);
        }
    }
}
