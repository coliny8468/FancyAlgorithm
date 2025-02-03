import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 가중치 기준 오름차순 정렬
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 개수
        int road = sc.nextInt(); // 간선 개수
        
        while(n!=0 && road!=0){

            int total = 0;

            // 인접 리스트 초기화
            ArrayList<Node>[] map = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                map[i] = new ArrayList<>();
            }

            // 간선 입력
            for (int i = 0; i < road; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int length = sc.nextInt();
                total += length;

                map[a].add(new Node(b, length));
                map[b].add(new Node(a, length));
            }

            // 프림 알고리즘 시작
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(0, 0)); // 시작 정점은 0번 정점
            boolean[] v = new boolean[n];
            int min = 0;

            while (!q.isEmpty()) {
                Node now = q.poll();

                if (v[now.to]) continue; // 이미 방문한 정점은 스킵
                v[now.to] = true; // 정점 방문 처리
                min += now.weight; // MST 가중치 추가

                // 현재 정점과 연결된 간선들 탐색
                for (Node next : map[now.to]) {
                    if (!v[next.to]) {
                        q.add(next);
                    }
                }
            }

            // 총 가중치에서 MST 가중치를 뺀 결과 출력
            System.out.println(total - min);
            
            n = sc.nextInt();
            road = sc.nextInt();
            
        }
            
      
    }
}
