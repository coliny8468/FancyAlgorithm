import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281 {

    static int n;
    static int[][] map; // [이닝번호][선수번호]
    static int[] sequence = new int[9];
    static int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9};
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][10];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permute(numbers, 0);
        System.out.println(max);
    }

    public static void permute(int[] arr, int depth) {
        if (depth == arr.length) {
            sequence[3] = 1; // 4번째 자리에 1 고정
            for (int i = 0, j = 0; i < 9; i++) {
                if (i == 3) continue;
                sequence[i] = arr[j++];
            }
            calcScore();
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1);
            swap(arr, depth, i); // 복구
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void calcScore() {
        int totalScore = 0;
        int sn = 0;
        for (int i = 1; i <= n; i++) {
            int out = 0;
            int score = 0;
            boolean[] position = new boolean[4];
            while (out < 3) {
                int s = map[i][sequence[sn]];
                if (s == 0) {
                    out++;
                } else if (s == 1) {
                    if (position[3]) {
                        score++;
                        position[3] = false;
                    }
                    if (position[2]) {
                        position[3] = true;
                        position[2] = false;
                    }
                    if (position[1]) {
                        position[2] = true;
                    }
                    position[1] = true;
                } else if (s == 2) {
                    if (position[3]) {
                        score++;
                        position[3] = false;
                    }
                    if (position[2]) {
                        score++;
                    }
                    if (position[1]) {
                        position[3] = true;
                        position[1] = false;
                    }
                    position[2] = true;
                } else if (s == 3) {
                    if (position[3]) {
                        score++;
                    }
                    if (position[2]) {
                        score++;
                        position[2] = false;
                    }
                    if (position[1]) {
                        score++;
                        position[1] = false;
                    }
                    position[3] = true;
                } else if (s == 4) {
                    if (position[3]) {
                        score++;
                        position[3] = false;
                    }
                    if (position[2]) {
                        score++;
                        position[2] = false;
                    }
                    if (position[1]) {
                        score++;
                        position[1] = false;
                    }
                    score++;
                }

                if (sn == 8) {
                    sn = 0;
                } else {
                    sn++;
                }
            }
            totalScore += score;
        }
        max = Math.max(max, totalScore);
    }
}
