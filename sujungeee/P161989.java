// https://school.programmers.co.kr/learn/courses/30/lessons/161989
package com.programmers.jul_2025;

/**
 * 161989: 덧칠하기
 * # summary
 * : 최소 횟수로 페인트를 덧칠하기
 * # access
 * : 그리디 알고리즘!? 오름차순 정렬이 되어있으니 롤러 크기만큼 차례대로 칠하면 될 것 같다.
 * # logic
 * 1. 칠해지지 않은 첫 번째 섹션에 롤러를 칠하고(answer = 1), 롤러가 칠해지는 마지막 섹션(end)을 구한다.
 * 2. 칠해지지 않은 섹션이 마지막 섹션(end)을 넘으면 다시 롤러를 칠하고, 롤러가 칠해지는 마지막 섹션을 갱신한다. (반복)
 * 3. 롤러가 칠해진 최소 횟수 answer를 return한다.
 */

class Solution161989 {
    public int solution(int n, int m, int[] section) {
        // 1
        int answer = 1;
        int end = section[0] + m - 1;

        // 2
        for(int i = 0; i < section.length; i++) {
            if (section[i] > end) {
                end = section[i] + m - 1;
                answer++;
            }
        }

        // 3
        return answer;
    }
}

public class P161989 {
    public static void main(String[] args) {
        Solution161989 s = new Solution161989();

        System.out.println(s.solution(8, 4, new int[] {2, 3, 6}));
        System.out.println(s.solution(5, 4, new int[] {1, 3}));
        System.out.println(s.solution(4, 1, new int[] {1, 2, 3, 4}));
    }
}