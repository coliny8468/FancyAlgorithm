package com.programmers.aug_2025;

/**
 * 42747: H-Index
 * # summary
 * : h번 이상 인용된 논문이 h편 이상인 h 구하기
 * # access
 * 1. h(value) 이상인 개수가 h이어야 한다.
 *    => 따라서 정렬을 통해 개수를 구하자!
 * # logic
 * 1. 논문들을 인용 횟수의 오름차순으로 정렬한다.
 * 2. 특정 횟수(h) 이상인 논문 개수(cnt)를 구한다.
 *    (오름차순 정렬을 진행하였기 때문에, 모두 h 이상일 것이다.)
 * 3. 인용 횟수(value)가 논문 개수(cnt) 이상이면 -> 만족하는 최소값인 cnt를 answer로 갱신하고 break한다.
 */

import java.util.Arrays;

class Solution42747 {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        // 1
        Arrays.sort(citations);

        for (int i = 0; i < length; i++) {
            // 2
            int cnt = length - i;
            // 3
            int value = citations[i];
            if (value >= cnt) {
                answer = cnt;
                break;
            }
        }

        return answer;
    }
}

public class P42747 {
    public static void main(String[] args) {
        Solution42747 s = new Solution42747();

        System.out.println(s.solution(new int[] {3, 0, 6, 1, 5}));
    }
}
