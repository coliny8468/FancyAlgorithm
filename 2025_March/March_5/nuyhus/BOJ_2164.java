import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        if (q.size() == 1) {
            System.out.println(q.remove());
            return;
        }

        q.remove();
        while (q.size() > 1) {
            q.add(q.remove());
            q.remove();
        }

        System.out.println(q.remove());
    }
}
