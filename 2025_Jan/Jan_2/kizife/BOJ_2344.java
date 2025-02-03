import java.util.Scanner;

public class BOJ_2344 {
    static int[][] box = new int[1005][1005]; //최대 1000크기인데 경계선까지 처리하려고 여유롭게
    static int[] result = new int[4005]; // 최대구멍수 = 2*(n+m)...인데 여유롭게 그냥

    static int[][] direction = { {0, 1}, {-1, 0} };//오른, 위

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int hole = 0; //구멍 번호

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int num = sc.nextInt();
                box[i][j] = (num == 1 ? -1 : 0); // 거울은 -1, 빈 칸은 0
            }
        }

        //테두리에 구멍 번호 넣기
        for (int i = 1; i <= n; i++) box[i][0] = ++hole; // 왼쪽
        for (int i = 1; i <= m; i++) box[n + 1][i] = ++hole; // 아래쪽
        for (int i = n; i > 0; i--) box[i][m + 1] = ++hole; // 오른쪽
        for (int i = m; i > 0; i--) box[0][i] = ++hole; // 위쪽

        //각 구멍에서 빛의 도착 위치 계산
        for (int i = 1; i <= n; i++) {
            int arrive = dfs(i, 0, 0);
            result[box[i][0]] = arrive;
            result[arrive] = box[i][0];
        }
        for (int i = 1; i <= m; i++) {
            int arrive = dfs(n + 1, i, 1);
            result[box[n + 1][i]] = arrive;
            result[arrive] = box[n + 1][i];
        }

        // 결과 출력
        for (int i = 1; i <= hole; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private static int dfs(int x, int y, int nowDir) {
        if (box[x][y] == -1) {
            nowDir = (nowDir + 1) % 2; //방향 전환
        }
        int nx = x + direction[nowDir][0];
        int ny = y + direction[nowDir][1];

        // 구멍에 도달한 경우
        if (box[nx][ny] != 0 && box[nx][ny] != -1) {
            return box[nx][ny];
        }
        return dfs(nx, ny, nowDir);
    }
}
