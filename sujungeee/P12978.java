

package com.programmers.jul_2025;

/**
 * 12978: 배달
 * # summary
 * : 1번부터 N번까지 최소 거리가 K 이하인 마을의 개수를 구하기
 * # access
 * 1. 1번부터 N번까지 최소 거리를 구하기(by 다익스트라)
 * 2. 최소 거리들(distances) 중 K 이하인 마을의 개수를 구하기
 * # logic
 * 1. 도로 정보를 graph에 저장한다(idx: 출발지, 0: cost, 1: 목적지)
 * 2. dijkstra(): 마을 간 최소 거리를 구하는 함수
 *     2-1. 마을 간 거리가 최소인 정보부터 꺼낼 수 있도록 PriorityQueue를 정의한다.
 *     2-2. 시작 비용(0)과 출발지(1)를 queue에 추가한다.
 *     2-3. queue에서 꺼낸 비용이 기존 마을에서의 최소 비용(distances)보다 크면 건너뛴다.
 *     2-4. 꺼낸 노드까지의 비용과 다음 노드로 가는 비용을 더한 값이 -> 다음 노드의 최소 비용보다 작으면
 *         2-4-1. 더한 값으로 다음 노드의 최소 비용을 갱신하고
 *         2-4-2. 다음 노드까지의 최소 비용과 다음 노드를 queue에 추가한다.
 * 3. distances에서 값이 K 이하인 개수를 구하여 return한다.
 */

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution12978 {
    PriorityQueue<int[]> queue;
    int[] distances;
    List<List<int[]>> graph;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // 1
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int[] info : road) { // cost, 목적지
            graph.get(info[0]).add(new int[] {info[2], info[1]});
            graph.get(info[1]).add(new int[] {info[2], info[0]});
        }

        // 2
        dijkstra();

        // 3
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) answer++;
        }

        return answer;
    }

    public void dijkstra() {
        int start = 1;
        distances[start] = 0;
        // 2-1
        queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // 2-2
        queue.add(new int[] {0, start});

        while (!queue.isEmpty()) {
            // 2-3
            int[] Node = queue.poll();
            int distance = Node[0];
            int node = Node[1];
            if (distance > distances[node]) continue;

            for (int[] newInfo : graph.get(node)) {
                int nextCost = newInfo[0] + distance;
                int nextNode = newInfo[1];

                // 2-4
                if (nextCost < distances[nextNode]) {
                    // 2-4-1
                    distances[nextNode] = nextCost;
                    // 2-4-2
                    queue.add(new int[] {nextCost, nextNode});
                }
            }
        }
    }
}

public class P12978 {
    public static void main(String[] args) {
        Solution12978 s = new Solution12978();

        System.out.println(s.solution(5, new int[][] {
                {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
        }, 3));

        System.out.println(s.solution(6, new int[][] {
                {1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}
        }, 4));
    }
}
