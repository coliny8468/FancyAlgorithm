import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cityN = sc.nextInt();  // 도시 개수
        int roadN = sc.nextInt();  // 도로 개수
        int k = sc.nextInt();      // 목표 거리
        int startCity = sc.nextInt(); // 시작 도시

        // 도시 번호가 1부터 시작하는 경우를 처리하기 위해 도시 번호를 0부터 인덱싱
        startCity--; // 1부터 시작하는 도시 번호를 0부터 인덱싱하도록 수정

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < cityN; i++) {
            graph.add(new ArrayList<>());
        }

        // 도로 정보 입력
        for (int i = 0; i < roadN; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--; // 1부터 시작하는 도시 번호를 0부터 인덱싱하도록 수정
            b--; // 1부터 시작하는 도시 번호를 0부터 인덱싱하도록 수정
            graph.get(a).add(b); // 단방향 도로
        }

        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[cityN];
        Arrays.fill(distance, -1);  // -1로 초기화 (방문하지 않은 상태)

        queue.add(startCity);
        distance[startCity] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (distance[next] == -1) {  // 아직 방문하지 않은 도시
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        // 최소 거리가 k인 도시들 출력
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cityN; i++) {
            if (distance[i] == k) {
                result.add(i + 1);  // 출력 시 1부터 시작하는 도시 번호로 복원
            }
        }

        // 결과 출력
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int city : result) {
                System.out.println(city);
            }
        }

        sc.close();
    }
}
