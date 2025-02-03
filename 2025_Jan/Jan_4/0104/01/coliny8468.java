import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> tree; // 트리를 Map으로 구성하여 메모리 절약
    static int[] subTreeSize;               // 서브트리 크기 저장
    static boolean[] visited;               // 방문 여부 확인

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        int N = scanner.nextInt(); // 트리의 정점 수
        int R = scanner.nextInt(); // 루트 번호
        int Q = scanner.nextInt(); // 쿼리 수

        tree = new HashMap<>();
        subTreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int U = scanner.nextInt();
            int V = scanner.nextInt();
            tree.get(U).add(V);
            tree.get(V).add(U);
        }

        // 서브트리 크기 계산
        calculateSubTreeSize(R);

        // 쿼리 처리
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int U = scanner.nextInt();
            result.append(subTreeSize[U]).append("\n");
        }

        System.out.print(result.toString());
        scanner.close();
    }

    // 서브트리 크기를 계산하는 DFS
    static int calculateSubTreeSize(int node) {
        visited[node] = true; // 현재 노드 방문 표시
        int size = 1;         // 현재 노드 포함

        for (int child : tree.get(node)) {
            if (!visited[child]) {
                size += calculateSubTreeSize(child); // 자식 노드의 서브트리 크기 더하기
            }
        }

        subTreeSize[node] = size; // 서브트리 크기 저장
        return size;
    }
}
