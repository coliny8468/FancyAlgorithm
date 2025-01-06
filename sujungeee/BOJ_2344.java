// https://www.acmicpc.net/problem/2344
// 2344: 거울
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class BOJ_2344 {
    public static int N, M;
    public static int[][] boxes;
    public static int[] dx= {0, -1, 0, 1}; // 우 상 좌 하
    public static int[] dy= {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        boxes= new int[N+2][M+2];
        for(int i=1; i<N+1; i++) {
            st= new StringTokenizer(br.readLine());
            for(int j=1; j<M+1; j++) {
                boxes[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        // 1. 가장자리에 숫자 채우기
        int seq= 1;
        for(int i=1; i<N+1; i++) { boxes[i][0]= seq++; }

        for(int i=1; i<M+1; i++){ boxes[N+1][i]= seq++; }

        for(int i=N; i>=1; i--) { boxes[i][M+1]= seq++; }

        for(int i=M; i>=1; i--) { boxes[0][i]= seq++; }

        // 2. 1번부터 시작
        StringBuilder sb= new StringBuilder();

        for (int i = 1; i < seq; i++) {
            int[] start = findStart(i);
            int x = start[0], y = start[1], dir = start[2];
            x+= dx[dir];
            y+= dy[dir];

            while (!is_edge(x, y)) {
                if (boxes[x][y] == 1) {
                    dir = change_dir(dir);
                }
                x += dx[dir];
                y += dy[dir];
            }
            sb.append(boxes[x][y]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    // 가장자리 번호의 시작 좌표와 방향 반환
    public static int[] findStart(int num) {
        for (int i = 1; i <= N; i++) {
            if (boxes[i][0] == num) return new int[]{i, 0, 0};
        }
        for (int i = 1; i <= M; i++) {
            if (boxes[N + 1][i] == num) return new int[]{N + 1, i, 1};
        }
        for (int i = N; i >= 1; i--) {
            if (boxes[i][M + 1] == num) return new int[]{i, M + 1, 2};
        }
        for (int i = M; i >= 1; i--) {
            if (boxes[0][i] == num) return new int[]{0, i, 3};
        }
        return null;
    }

    // 현재 위치가 가장자리인지 확인하는 함수
    public static boolean is_edge(int x, int y) {
        return (x == 0 || x == N + 1 || y == 0 || y == M + 1);
    }

    // 상자가 대각선일 때 방향을 바꾸는(반사하는) 함수
    public static int change_dir(int idx) {
        if (idx == 0) {
            return 1;
        } else if (idx == 3) {
            return 2;
        } else if (idx == 2) {
            return 3;
        } else if (idx == 1) {
            return 0;
        }
        return -1;
    }
}