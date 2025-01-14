import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2668 {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n + 1];
        visit = new boolean[n + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int j = 1; j <= n; j++) {
            visit[j] = true;
            dfs(j, j);
            visit[j] = false;
        }

        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    static void dfs(int value, int i) {
        if (!visit[arr[value]]) {
            visit[arr[value]] = true;
            dfs(arr[value], i);
            visit[arr[value]] = false;
        }
        if (arr[value] == i) {
            result.add(arr[value]);
        }
    }
}
