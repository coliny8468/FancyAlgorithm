// https://school.programmers.co.kr/learn/courses/30/lessons/42626
package com.programmers.jul_2025;

import java.util.PriorityQueue;

/**
 * 42626: 더 맵게
 * # summary
 * : 모든 스코빌 지수가 K 이상일 때까지 섞어야 할 최소 횟수
 * # access
 * 1. 정렬 하기!
 * 2. 근데 사실 최솟값들만 필요한 것이라 최소힙을 쓰면 된다.
 * # logic
 * 1. 우선순위 큐에 모든 스코빌 지수를 넣는다.
 * 2. while문을 돌면서 새로운 음식을 만들 수 있으면(우선순위 큐에 스코빌 지수가 있으면) 음식을 섞고,
 *    새로운 음식을 만들 수 없으면(우선순위 큐에 스코빌 지수가 더 이상 없으면) -1을 return한다.
 */

class Solution42626 {
    PriorityQueue<Integer> pQueue;
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 1
        pQueue = new PriorityQueue<>();
        for (int value : scoville) {
            pQueue.add(value);
        }

        // 2
        while (!pQueue.isEmpty() && pQueue.peek() < K) {
            int lowest = pQueue.poll();
            if (!pQueue.isEmpty()) {
                int lowest2 = pQueue.poll();
                pQueue.add(lowest + (lowest2 * 2));
                answer++;
            } else {
                return -1;
            }
        }

        return answer;
    }
}

public class P42626 {
    public static void main(String[] args) {
        Solution42626 s = new Solution42626();

        System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
}