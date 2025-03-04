// https://www.acmicpc.net/problem/2161
// 2161: 카드 1
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_2161 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pollFirst()).append(" ");
            if (!queue.isEmpty()) {
                queue.addLast(queue.pollFirst());
            }
        }
        System.out.println(sb);
    }
}