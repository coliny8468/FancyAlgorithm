import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        for (int i = 0; i < n-1; i++) {
            System.out.print(queue.poll() + " ");
            queue.add(queue.poll()); // 두 번째에 있는 걸 맨 뒤로...
        }

        System.out.println(queue.poll());
    }
}
