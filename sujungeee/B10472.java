import java.io.*;
import java.util.*;

public class B10472 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int P;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= P; testCase++) {
            // 1
            int state = 0;
            for (int i = 0; i < 3; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    if (tmp[j] == '*') {
                        state |= (1 << (i * 3 + j));
                    }
                }
            }

            System.out.println(search(state));
        }
    }

    // 3
    public static int flip(int state, int idx) {
        int x = idx / 3;
        int y = idx % 3;
        // 3-1
        state ^= (1 << idx);

        // 3-2
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= 3 || newY < 0 || newY >=3) continue;
            int newIdx = 3 * newX + newY;
            state ^= (1 << newIdx);
        }

        return state;
    }

    // 2
    public static int search(int start) {
        // 2-1
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[1 << 9];
        queue.add(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.pollFirst();
            int state = info[0];
            int cnt = info[1];

            // 2-2
            if (state == 0) return cnt;

            // 2-3
            for (int i = 0; i < 9; i++) {
                int newState = flip(state, i);
                if (!visited[newState]) {
                    visited[newState] = true;
                    queue.add(new int[] {newState, cnt + 1});
                }
            }
        }
        return -1;
    }
}