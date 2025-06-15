// https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

/**
 * 49189: 가장 먼 노드
 * # summary
 * : 1번 노드로부터 가장 멀리 떨어진 노드의 개수 구하기
 * # access
 * 1. 이 문제가 바로 다익스트라를 활용할 수 있는 문제다!
 * 이유: 한 정점으로 부터 각 정점까지의 최단 거리를 알아야 하기 때문
 * => 각 정점까지의 최단 거리가 가장 큰 정점의 개수를 구하자.
 * # logic
 * 1. 각 간선 정보를 infos에 저장(양방향 간선이므로 두 정점에 모두 추가)
 *    infos: (정점) - (정점과 간선으로 이어진 다른 정점들)
 * 2. dijkstra()
 *    2-1. 1번부터 각 정점까지의 최단 거리를 MAX로 설정
 *    2-2. 1번 정점과 거리 0을 queue에 넣는다.
 *    2-3. queue에서 꺼낸 정점까지의 거리가 최단 거리(distances 값)보다 작으면 최단 거리 갱신
 *        && 꺼낸 정점의 인접한 정점까지의 거리가 최단 거리보다 작으면 queue에 추가
 * 3. 최댓값을 가지는 정점 개수를 출력.
 */

class Solution49189 {
    int[] distances;
    List<Integer>[] infos;
    public int solution(int n, int[][] edges) {
        int answer = 0;

        // 1
        infos = new List[n + 1];
        for (int i = 1; i <= n; i++) infos[i] = new ArrayList<>();
        for (int[] edge: edges) {
            infos[edge[0]].add(edge[1]);
            infos[edge[1]].add(edge[0]);
        }

        dijkstra(n);

        // 3
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] > maxValue) {
                maxValue = distances[i];
                answer = 1;
            } else if (distances[i] == maxValue) {
                answer++;
            }
        }
        return answer;
    }

    void dijkstra(int n) {
        // 2-1
        distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        ArrayDeque<int[]> proceeds = new ArrayDeque<>();
        // 2-2
        proceeds.addLast(new int[] {1, 0});

        while(!proceeds.isEmpty()) {
            int[] Node = proceeds.pollFirst();
            int node = Node[0];
            int distance = Node[1];

            // 2-3
            if (distance < distances[node]) {
                distances[node] = distance;
                for (int newNode : infos[node]) {
                    if (distances[newNode] > distance + 1) {
                        proceeds.addLast(new int[]{newNode, distance + 1});
                    }
                }
            }
        }
    }
}

public class P49189 {
    public static void main(String[] args) {
        Solution49189 s = new Solution49189();

        System.out.println(s.solution(6, new int[][] {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        }));
    }
}