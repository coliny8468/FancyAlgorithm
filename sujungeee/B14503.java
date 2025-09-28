import java.io.*;
import java.util.*;

public class B14503 {
    final static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    final static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true) {
            // 1
            if (room[r][c] == 0) {
                room[r][c] = 2;
                answer++;
            }

            // 2
            boolean isExist = false;
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];

                if (room[newR][newC] == 0) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                int newR = r - dx[d];
                int newC = c - dy[d];
                if (room[newR][newC] == 1) { // 2-2
                    break;
                } else { // 2-1
                    r = newR;
                    c = newC;
                }
            } else {
                // 3-1
                d = (4 + d - 1) % 4;
                // 3-2
                int newR = r + dx[d];
                int newC = c + dy[d];
                if (room[newR][newC] == 0) {
                    r = newR;
                    c = newC;
                }
            }
        }

        // 4
        System.out.println(answer);
    }
}