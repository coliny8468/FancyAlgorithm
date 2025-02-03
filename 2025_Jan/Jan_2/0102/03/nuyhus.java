import java.util.*;
import java.io.*;

public class nuyhus {

    static int boardSize, appleSize, changeSize;
    static int[][] appleInfo;
    static HashMap<Integer, String> changeInfo;
    static int[][] board;
    static int[] head = new int[2];
    static int[] tail = new int[2];
    static int[][] d = {{0, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boardSize = Integer.parseInt(br.readLine());
        board = new int[boardSize][boardSize];

        appleSize = Integer.parseInt(br.readLine());
        appleInfo = new int[appleSize][2];
        for (int i = 0; i < appleSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                appleInfo[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        changeSize = Integer.parseInt(br.readLine());
        changeInfo = new HashMap<>();
        for (int i = 0; i < changeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            changeInfo.put(time, direction);
        }

        board[0][0] = 1;
        go(0, 0, 1);

        System.out.println(cnt);
    }

    static void go(int x, int y, int dir) {
        cnt++;

        int nx = x + d[dir][0];
        int ny = y + d[dir][1];

        if (nx < 0 || ny < 0 || nx >= boardSize || ny >= boardSize || board[nx][ny] != 0) {
            return;
        }

        head[0] = nx;
        head[1] = ny;

        boolean isApple = false;
        for (int i = 0; i < appleSize; i++) {
            if (nx == appleInfo[i][0] && ny == appleInfo[i][1]) {
                appleInfo[i][0] = -1;
                appleInfo[i][1] = -1;
                isApple = true;
                break;
            }
        }

        int tailX = tail[0];
        int tailY = tail[1];
        if (!isApple) {
            tail[0] = tail[0] + d[board[tailX][tailY]][0];
            tail[1] = tail[1] + d[board[tailX][tailY]][1];
            board[tailX][tailY] = 0;
        }

        if (changeInfo.containsKey(cnt)) {
            String temp = changeInfo.get(cnt);
            if (temp.equals("D")) {
                dir++;
                if (dir == 5) {
                    dir = 1;
                }
            } else if (temp.equals("L")) {
                dir--;
                if (dir == 0) {
                    dir = 4;
                }
            }
        }

        board[nx][ny] = dir;
        go(nx, ny, dir);
    }
}
