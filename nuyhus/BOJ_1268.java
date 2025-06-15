import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] answerMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][5];
        answerMap = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) break;
                    if (map[k][j] == map[i][j]) {
                        answerMap[i][k] = true;
                        answerMap[k][i] = true;
                    }
                }
            }
        }

        int answer = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (answerMap[i][j]) {
                    temp++;
                }
            }
            if (max < temp) {
                answer = i;
                max = temp;
            }
        }

        System.out.println(answer + 1);
    }
}
