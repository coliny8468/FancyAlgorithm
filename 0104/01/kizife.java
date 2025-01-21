import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree; //트리 저장할 인접 리스트
    static int[] subtreeSize; //각 노드의 서브트리 크기 저장
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int q = sc.nextInt();

        tree = new ArrayList<>();
        //트리 초기화 (0번 인덱스는 사용 x)
        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            tree.get(u).add(v); //u->v 연결
            tree.get(v).add(u); //v->u 연결
        }

        subtreeSize = new int[n + 1];
        visited = new boolean[n + 1];
        findSize(r); //dfs

        for (int i = 0; i < q; i++) {
            int check = sc.nextInt();
            System.out.println(subtreeSize[check]);
        }
    }

    //서브트리 크기 계산
    static int findSize(int node) {
        visited[node] = true; //현재노드 방문처리하고
        subtreeSize[node] = 1; //자기 자신도 포함이기에, 1로 초기화

        // 현재 노드와 연결된 다른 노드들 확인
        for (int child : tree.get(node)) {
            if (!visited[child]) {
                subtreeSize[node] += findSize(child); //자식노드의 서브트리 크기 추가
            }
        }

        return subtreeSize[node]; //계산된 크기 반환 
    }
}
