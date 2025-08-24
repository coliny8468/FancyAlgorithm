// https://school.programmers.co.kr/learn/courses/30/lessons/118666
package com.programmers.aug_2025;

/**
 * 118666: 성격 유형 검사하기
 * # summary
 * : 더 많은 점수를 가진 성격 유형을 출력하기
 * # access
 * : 문제 말을 잘 따라 구현하자.
 * # logic
 * 1. 각 유형에 대한 점수를 0으로 초기화한다.
 * 2. choices의 선택에 따라 점수를 줄 유형(idx)을 선택하여 점수(score)를 "유형이 가지고 있는 원래 점수"에 합산한다.
 *    (4점 미만이면 0번째 유형, 4점 초과이면 1번째 유형 선택)
 * 3. 1 ~ 4번 지표에 대해 두 유형 중 많은 점수를 가진 유형을 answer에 넣는다.
 *    단, 두 점수가 같다면 사전 순으로 빠른 앞쪽 유형을 answer에 넣는다.
 */

import java.util.Map;
import java.util.HashMap;

class Solution118666 {
    String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
    Map<String, Integer> scores;

    public String solution(String[] survey, int[] choices) {
        // 1
        scores = new HashMap<>();
        for (String type : types) {
            scores.put(type, 0);
        }
        StringBuilder answer = new StringBuilder();

        // 2
        for(int i = 0; i < survey.length; i++) {
            int score = 0;
            int idx = 0;
            if(choices[i] < 4) {
                score = 4 - choices[i];
                idx = 0;
            } else if (choices[i] > 4) {
                score = choices[i] - 4;
                idx = 1;
            }
            String type = String.valueOf(survey[i].charAt(idx));
            scores.put(type, scores.get(type) + score);
        }

        // 3
        for (int i = 0; i < 8; i += 2) {
            String type1 = types[i];
            String type2 = types[i + 1];
            int score1 = scores.get(type1);
            int score2 = scores.get(type2);
            if (score1 > score2) {
                answer.append(type1);
            } else if (score1 < score2) {
                answer.append(type2);
            } else {
                answer.append(type1);
            }
        }

        return answer.toString();
    }
}

public class P118666 {
    public static void main(String[] args) {
        Solution118666 s = new Solution118666();

        System.out.println(s.solution(new String[] {"AN", "CF", "MJ", "RT", "NA"},
                new int[] {5, 3, 2, 7, 5}));
        System.out.println(s.solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}));
        System.out.println(s.solution(new String[] {"RT", "RT", "RT"}, new int[] {7, 2, 4}));
    }
}