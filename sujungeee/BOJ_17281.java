// https://www.acmicpc.net/problem/17281
// 17281: ⚾
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281 {
    public static int N;
    public static int[][] info;
    public static int[] arrs = new int[9];
    public static boolean[] visited = new boolean[9];
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrs[3] = 0;
        visited[0] = true;
        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int cnt) {
        if (cnt == 9) {
            gameStart();
            return;
        }

        if (cnt == 3) {
            permutation(cnt + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrs[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void gameStart() {
        int score = 0;
        int idx = 0;
        boolean[] bases = new boolean[3];

        for (int cycle = 0; cycle < N; cycle++) {
            int outCnt = 0;
            bases = new boolean[] {false, false, false};

            while (outCnt < 3) {
                int type = info[cycle][arrs[idx]];

                if (type == 0) {
                    outCnt++;
                } else {
                    if (type == 1) {
                        if (bases[2]) score++;
                        bases[2] = bases[1];
                        bases[1] = bases[0];
                        bases[0] = true;
                    } else if (type == 2) {
                        if (bases[2]) score++;
                        if (bases[1]) score++;
                        bases[2] = bases[0];
                        bases[1] = true;
                        bases[0] = false;
                    } else if (type == 3) {
                        for (int i = 0; i < 3; i++) {
                            if (bases[i]) score++;
                            bases[i] = false;
                        }
                        bases[2] = true;
                    } else if (type == 4) {
                        for (int i = 0; i < 3; i++) {
                            if (bases[i]) score++;
                            bases[i] = false;
                        }
                        score++;
                    }
                }

                idx = (idx + 1) % 9;
            }
        }

        answer = Math.max(answer, score);
    }
}