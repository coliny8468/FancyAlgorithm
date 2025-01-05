// https://www.acmicpc.net/problem/16724
// 16724: 피리 부는 사나이
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class sujungeee {
    public static int answer;
    public static int N, M;
    public static char[][] map;
    public static int[][] visited;
    public static int turns;

    public static void main(String[] args) throws IOException {
        answer= 0;
        turns= 1;

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        visited= new int[N][M];
        map= new char[N][M];
        for(int i=0; i<N; i++) {
            map[i]= br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    // 방향에 따라 새 좌표를 계산하는 함수
    public static int[] new_coords(int x, int y) {
        char dir= map[x][y];
        if (dir == 'D') {
            return new int[] {x+1, y};
        } else if (dir == 'U') {
            return new int[] {x-1, y};
        } else if (dir == 'L') {
            return new int[] {x, y-1};
        } else {
            return new int[] {x, y+1};
        }
    }

    public static void bfs(int x, int y) {
        visited[x][y]= turns;
        int[] news= new_coords(x, y);
        int newx= news[0];
        int newy= news[1];

        if (visited[newx][newy] == 0) { // 새 좌표가 방문되지 않은 좌표이면
            bfs(newx, newy); // 계속해서 탐색
        } else { // 새 좌표가 방문된 좌표이면
            if (visited[newx][newy] == turns) { // 이번턴에 사이클이 형성되었다면
                answer++; // safe-zone +1
            }
            turns++; // 다음 경로의 수를 위해 +1
        }
    }
}