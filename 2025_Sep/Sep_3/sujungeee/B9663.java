import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9663 {
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        boolean[] visited = new boolean[N]; // 열에 퀸이 있는지 확인하는 배열
        boolean[] diag1 = new boolean[2 * N]; // 우측 하단으로 향하는 대각선 배열
        boolean[] diag2 = new boolean[2 * N]; // 좌측 하단으로 향하는 대각선 배열
        Arrays.fill(visited, false);
        Arrays.fill(diag1, false);
        Arrays.fill(diag2, false);

        search(0, arr, visited, diag1, diag2);

        System.out.println(answer);
    }

    public static void search(int row, int[][] arr, boolean[] visited, boolean diag1[], boolean diag2[]) {
        // 1
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            // 2
            if (visited[col]) continue;

            // 3
            int idx1 = col - row + N;
            int idx2 = row + col;

            // 4
            if (!diag1[idx1] && !diag2[idx2]) {
                visited[col] = diag1[idx1] = diag2[idx2] = true;
                arr[row][col] = 1;

                search(row + 1, arr, visited, diag1, diag2);

                arr[row][col] = 0;
                visited[col] = diag1[idx1] = diag2[idx2] = false;
            }
        }
    }
}