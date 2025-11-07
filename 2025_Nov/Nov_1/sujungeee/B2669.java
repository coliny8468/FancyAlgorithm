import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[101][101];
        answer = 0;

        for (int k = 0; k < 4; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}