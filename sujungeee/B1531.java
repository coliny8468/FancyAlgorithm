import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] picture;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        picture = new int[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    picture[x][y]++;
                }
            }
        }

        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                if (picture[x][y] > M) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}