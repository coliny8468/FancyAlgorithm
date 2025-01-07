import java.util.*;
import java.io.*;

public class nuyhus {

    static int n, m;
    static int[][] map;
    static int[][] d = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            go(0, i, 0);
        }

        for (int i = 0; i < m; i++) {
            go(1, n - 1, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            go(2, i, m - 1);
        }

        for (int i = m - 1; i >= 0; i--) {
            go(3, 0, i);
        }

        System.out.println(sb.toString());
    }

    static void go(int dir, int x, int y) {

        int ndir = dir;
        if (map[x][y] == 1) {
            ndir = calcDir(dir);
        }

        int nx = x + d[ndir][0];
        int ny = y + d[ndir][1];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            go(ndir, nx, ny);
        } else {
            sb.append(getExitNum(ndir, x, y)).append(" ");
        }
    }

    static int calcDir(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        if (dir == 3) return 2;

        return -1;
    }

    static int getExitNum(int dir, int x, int y) {

        if (dir == 0) {
            return n + m + (n - x);
        }
        if (dir == 1) {
            return 2 * n + m + (m - y);
        }
        if (dir == 2) {
            return x + 1;
        }
        if (dir == 3) {
            return y + n + 1;
        }

        return -1;
    }
}
