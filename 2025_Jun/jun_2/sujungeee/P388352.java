// https://school.programmers.co.kr/learn/courses/30/lessons/388352

import java.util.*;

/**
 * 388352: 비밀 코드 해독
 * # summary
 * : 입력과 일치 개수로 비밀 코드를 몇 개 만들 수 있는지 ?
 * # access
 * 1. 각 입력과 일치 개수를 보고 가능한 경우의 수를 생각하고,
 *    각 경우의 수를 하나의 조합(set 활용)으로 모아서 검증하려고 생각했음. (검증: 조합이 입력에서 실제로 일치하는 개수와 맞는지)
 *    하지만 각각 입력에서 조합 경우의 수를 추출하고, 또 하나의 조합으로 만들어 검증하기는 재귀를 활용하는 시점에서 너무 어렵다고 생각.
 * 2. 따라서 그냥 전체 nC5를 해서 전체 경우의 수에서 각각을 검증하는 것으로 생각을 전환.
 * # logic
 * 1. combination(): nCr 조합을 만들어내는 함수
 * 2. certify(): 만들어진 조합이 입력의 일치 개수와 전부 맞는지 검증하는 함수
 *     2-1. visited로 만들어진 조합의 원소를 set에 add
 *     2-2. 만들어진 조합과 입력 set의 교집합의 개수가 일치 개수와 "전부 일치"하면 answer + 1
 * 3. answer return
 */

class Solution388352 {
    boolean[] visited;
    int answer;
    int N;
    Set<Integer>[] inputs; // 각 입력 정수 배열을 set으로 변환
    int[] matches;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        N = n;
        inputs = new Set[q.length];
        for(int i = 0; i < q.length; i++) {
            inputs[i] = new HashSet<>();
            for (int value : q[i]) {
                inputs[i].add(value);
            }
        }
        matches = ans;

        visited = new boolean[n];
        combination(0,5);

        return answer;
    }

    // 1
    void combination(int start, int r) {
        if (r == 0) {
            certify();
            return;
        } else {
            for (int i = start; i < N; i++) {
                visited[i] = true;
                combination(i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    void certify() {
        // 2-1
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                result.add(i+1);
            }
        }

        // 2-2
        for (int i = 0; i < inputs.length; i++) {
            Set<Integer> intersection = new HashSet<>(result);
            intersection.retainAll(inputs[i]);
            if (intersection.size() != matches[i]) {
                return;
            }
        }
        answer++;
    }
}

public class P388352 {
    public static void main(String[] args) {
        Solution388352 s = new Solution388352();

        System.out.println(s.solution(10, new int[][] {
                {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}
        }, new int[] {2, 3, 4, 3, 3}));

        System.out.println(s.solution(15, new int[][] {
                {2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}
        }, new int[] {2, 1, 3, 0, 1}));
    }
}
