import java.util.*;

public class Main {
    static int n;
    static int from;
    static int[] nums;
    static List<Integer> answer = new LinkedList<>();
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        // 1부터 차례대로 n까지 사이클을 검사한다.
        for (int i = 1; i <= n; i++) {
            visit[i] = true;
            from = i;
            dfs(i);
            visit[i] = false;
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private static void dfs(int start) {
        // 다음 행선지
        int next = nums[start];

        if (!visit[next]) {
            visit[next] = true;
            dfs(next);
            visit[next] = false;
        }

        // 사이클이 생기면 경로를 answer에 저장한다.
        if (next == from) {
            // 다음 행선지가 시작점인 from이라면 사이클이 생긴 것이다.
            answer.add(from);
        }
    }
}
