import java.io.*;
import java.util.*;

public class nuyhus {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        visited = new boolean[n];
        answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            go(i, i);
            visited[i] = false;
        }

        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (int num : answer) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    static void go(int idx, int target) {
        if (!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            go(arr[idx], target);
            visited[arr[idx]] = false;
        }

        if (arr[idx] == target) {
            answer.add(target + 1);
        }
    }
}