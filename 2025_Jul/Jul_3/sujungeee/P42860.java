// https://school.programmers.co.kr/learn/courses/30/lessons/42860
package com.programmers.jul_2025;

/**
 * 42860: 조이스틱
 * # summary
 * : name을 만들 수 있도록 조이스틱을 움직이는 최소 횟수
 * # access
 * 1. 조작 횟수의 최소는 알파벳이 A쪽에 가까운지 or Z쪽에 가까운지만 생각하면 됨
 * 2. 이동 횟수의 최소는 다음 3가지로 나누어짐!
 *     2-1. 앞부터 뒤로(직선으로) 이동
 *     2-2. 앞으로 "특정 + 연속된 A 모음" 전까지 전진 -> 뒤로 "특정 + 연속된 A 모음" 후까지 후진
 *     2-3. 뒤로 "특정 + 연속된 A 모음" 후까지 후진 -> 앞으로 "특정 + 연속된 A 모음" 전까지 전진
 * # logic
 * 1. 각 문자의 최소 조작 횟수를 구한다.
 *    -> 알파벳과 A, 알파벳과 Z 사이의 간격을 구해 더 작은 쪽을 answer에 더한다!
 * 2. 문자 간의 최소 이동 횟수를 구한다.
 *     2-1. 직선으로 이동하는 경우의 수로 move를 초기화한다.
 *     2-2. 다음 인덱스에 A가 있으면 연속된 A 모음의 구간을 구한다.
 *     2-3. 연속된 A 모음의 구간을 제외한 (앞의 모음 개수)와 (뒤의 모음 개수)를 구한다.
 *     2-4. (앞의 모음 개수)와 (뒤의 모음 개수)로
 *           앞으로 먼저 전진하고 -> 뒤로 후진하는 frontFirst와
 *           뒤로 먼저 후진하고 -> 앞으로 전진하는 backFirst를 구한다.
 *     2-5. 두 경우의 수와 직선하는 경우의 수 중에서 최소인 이동 횟수를 move에 저장한다.
 * 3. 최소 조작 횟수와 최소 이동 횟수를 더해서 return한다.
 */

class Solution42860 {
    static int length;

    public int solution(String name) {
        length = name.length();
        int answer = 0;

        // 1
        for (int i = 0; i < length; i++) {
            int diff = Math.abs('A' - name.charAt(i));
            answer += Math.min(diff, 26 - diff);
        }

        // 2-1
        int move = length - 1;
        for (int i = 0; i < length; i++) {
            // 2-2
            int idx = i + 1;
            while (idx < length && name.charAt(idx) == 'A') {
                idx++;
            }

            // 2-3
            int front = i + 1; // 연속된 A 구간의 앞 개수
            int back = length - idx; // 연속된 A 구간의 뒤 개수

            // 2-4
            int frontFirst = (front - 1) * 2 + back;
            int backFirst = (back * 2) + front - 1;

            // 2-5
            move = Math.min(move, Math.min(frontFirst, backFirst));
        }
        // 3
        answer += move;

        return answer;
    }
}

public class P42860 {
    public static void main(String[] args) {
        Solution42860 s = new Solution42860();

//        System.out.println(s.solution("JEROEN"));
        System.out.println(s.solution("BBAAAAABBB"));
        System.out.println(s.solution("JAN"));
    }
}