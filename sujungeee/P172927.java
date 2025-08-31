// https://school.programmers.co.kr/learn/courses/30/lessons/172927
package com.programmers.jul_2025;

/**
 * 172927: 광물 캐기
 * # summary
 * : 모든 광물을 캐고 나서의 최소 피로도를 구하자.
 * # access
 * 1. 완전탐색 문제!!!!
 * => 곡괭이 수는 각 종류별로 5개씩, 최대 15개이므로.. 완전탐색이 가능하다.
 * # logic
 * 1. 광물을 캘때 쓸 곡괭이를 정하기 위한 변수들을 초기화한다.
 * => mineralCnt, pickCnt, pickTypes, pickToMineral
 * 2. recur(): 최소 피로도를 찾기 위해 써야할 곡괭이의 순서를 탐색하는 함수
 *     2-1. 모든 광물을 다 곡괭이로 캤거나, 모든 곡괭이를 다 소모하면
 *          -> 합산된 피로도(value)를 최소 피로도(answer)와 비교하여 작은 값으로 갱신한다.
 *     2-2. 곡괭이의 순서(0: 다이아몬드 곡괭이, 1: 철 곡괭이, 2: 돌 곡괭이)를 정해서 차례대로 광물을 캔다.
 *     2-3. 특정 곡괭이를 쓸 수 있다면(개수가 1 이상이라면)
 *     2-4. 곡괭이 수를 1 감소하고, 해당 과정에서 피로도(newValue)를 5번 연속 누적한다.
 *          만약, 5번동안 광물을 캐는 과정에서 광물을 모두 캐면 멈춘다.
 *     2-5. 특정 곡괭이로 광물을 다 캐면 -> 다음 광물을 캘 곡괭이를 찾기 위해 recur()를 호출한다.
 *     2-6. 재귀 호출을 마무리하면, 곡괭이 개수를 원상복구 시킨다.
 */

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution172927 {
    int answer;
    int mineralCnt; // 캐야할 광물 개수
    List<Integer> pickCnt; // 곡괭이 개수(0: 다이아몬드 곡괭이, 1: 철 곡괭이, 2: 돌 곡괭이)
    Map<String, Integer> pickTypes = Map.of(
            "diamond", 0
            , "iron", 1
            , "stone", 2
    );
    Map<Integer, int[]> pickToMineral = Map.of( // 곡괭이마다 광물을 캤을 때의 소모되는 피로도
            0, new int[] {1, 1, 1}
            , 1, new int[] {5, 1, 1}
            , 2, new int[] {25, 5, 1}
    );

    public int solution(int[] picks, String[] minerals) {
        // 1
        answer = Integer.MAX_VALUE;
        mineralCnt = minerals.length;
        pickCnt = new ArrayList<>();
        for (int p : picks) pickCnt.add(p);

        // 2
        recur(0, 0, pickCnt, minerals);

        return answer;
    }

    // 2
    public void recur(int idx, int value, List<Integer> picks, String[] minerals) {
        // 2-1
        if (idx == mineralCnt || (picks.get(0) == 0 && picks.get(1) == 0 && picks.get(2) == 0)) {
            answer = Math.min(answer, value);
            return;
        }

        // 2-2
        for (int i = 0; i < 3; i++) {
            int pickCnt = picks.get(i);
            // 2-3
            if (pickCnt > 0) {
                // 2-4
                picks.set(i, pickCnt - 1);
                int newValue = value;
                int limit = 0;
                for (int j = 0; j < 5; j++) {
                    if (idx + j == mineralCnt) break;
                    int mineralIdx = pickTypes.get(minerals[idx + j]);
                    newValue += pickToMineral.get(i)[mineralIdx];
                    limit++;
                }
                // 2-5
                recur(idx + limit, newValue, picks, minerals);

                // 2-6
                picks.set(i, pickCnt);
            }
        }
    }
}

public class P172927 {
    public static void main(String[] args) {
        Solution172927 s = new Solution172927();

        System.out.println(s.solution(new int[] {1, 3, 2}, new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        System.out.println(s.solution(new int[] {0, 1, 1}, new String[] {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}