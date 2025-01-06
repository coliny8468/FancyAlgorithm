import java.io.*;
import java.util.*;

public class BOJ_3190 {

    static int n, k, l;
    static int[][] board;
    static int[] head;
    static int[] tail;
    static int[][] apple;
    static String[][] change;
    static int[][] d = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][n];
        apple = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                apple[i][j] = sc.nextInt() - 1;
            }
        }
        l = sc.nextInt();
        change = new String[l][2];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 2; j++) {
                change[i][j] = sc.next();
            }
        }

        board[0][0] = 1;
        head = new int[2];
        tail = new int[2];
        go(0, 0, 1);

        System.out.println(cnt);
    }

    static void go(int x, int y, int idx) {

        // 시간 증가
        cnt++;

        // 이동
        int nx = x + d[idx][0];
        int ny = y + d[idx][1];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] != 0) {
            return;
        }

        // 머리 이동
        head[0] = nx;
        head[1] = ny;

        // 꼬리 이동
        int tailX = tail[0];
        int tailY = tail[1];

        boolean isApple = false;
        for (int i = 0; i < k; i++) {
            if (nx == apple[i][0] && ny == apple[i][1]) {
                apple[i][0] = -1;
                apple[i][1] = -1;
                isApple = true;
                break;
            }
        }

        if (!isApple) {
            tail[0] = tail[0] + d[board[tailX][tailY]][0];
            tail[1] = tail[1] + d[board[tailX][tailY]][1];
            board[tailX][tailY] = 0;
        }

        // 방향
        int nIdx = idx;
        for (int i = 0; i < l; i++) {
            if (Integer.parseInt(change[i][0]) == cnt) {
                if (change[i][1].equals("D")) {
                    nIdx += 1;
                    if (nIdx == 5) {
                        nIdx = 1;
                    }
                } else {
                    nIdx -= 1;
                    if (nIdx == 0) {
                        nIdx = 4;
                    }
                }

                break;
            }

            if (Integer.parseInt(change[i][0]) > cnt) {
                break;
            }
        }

        board[nx][ny] = nIdx;
        go(nx, ny, nIdx);
    }
}