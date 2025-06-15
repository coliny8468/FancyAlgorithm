import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b;
    static char[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static char[] white = new char[]{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
    static char[] black = new char[]{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
    static int min = 65;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new char[a][b];
        for (int i = 0; i < a; i++) {
            String temp = br.readLine();
            int j = 0;
            for (char ch : temp.toCharArray()) {
                map[i][j] = ch;
                j++;
            }
        }

        for (int startX = 0; startX + 7 < a; startX++) {
            for (int startY = 0; startY + 7 < b; startY++) {
                find(startX, startY);
            }
        }

        System.out.println(min);
    }

    static void find(int startX, int startY) {
        int answer = 0;
        char k;
        for (int i = startX; i < startX + 8; i++) {
            if (i % 2 == 0) {
                k = 'W';
            } else {
                k = 'B';
            }
            for (int j = startY; j < startY + 8; j++) {
                if (map[i][j] == k) {
                    answer++;
                }
                if (k == 'W') {
                    k = 'B';
                } else {
                    k = 'W';
                }
            }
        }

        answer = Math.min(answer, 64 - answer);
        min = Math.min(min, answer);
    }
}
