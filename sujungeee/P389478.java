// https://school.programmers.co.kr/learn/courses/30/lessons/389478
package com.programmers.jul_2025;

/**
 * 349478: 택배 상자 꺼내기
 * # summary
 * : 꺼내려는 상자가 위에서부터 몇 층이 있는지 구하기
 * # access
 * 1. 짝수 층은 오른쪽부터 / 홀수 층은 왼쪽부터 택배 상자가 쌓인다.
 * 2. 구현 문제 인가?
 * # logic
 * 1. 전체 1 ~ w가 각각 몇 층을 소유하는지 구한다.
 *     1-1. 보장되어 있는 층이 짝수이면, 다음이 홀수 층이므로 왼쪽부터 추가로 쌓아야 한다.
 *     1-2. 보장되어 있는 층이 홀수이면, 다음이 짝수 층이므로 오른쪽부터 추가로 쌓아야 한다.
 * 2. num이 몇 번째 w에 있는지 구한다.
 *     2-1. num이 짝수 층에 있으면, 층의 최대 숫자(w의 배수)와 num을 빼야 한다.
 *     2-2. num이 홀수 층에 있으면, w - 1 - (층의 최대 숫자(w의 배수)와 num)을 빼야 한다.
 * 3. w의 층 수에서 num의 층 수를 빼고 1을 더해서 answer에 할당한 후 return한다.
 */

class Solution389478 {
    int[] floors;

    public int solution(int n, int w, int num) {
        int answer = 0;

        // 1
        floors = new int[w];
        int allHaveFloor = n / w;
        int remainder = n % w;
        for (int i = 0; i < w; i++) floors[i] = allHaveFloor;
        if (allHaveFloor % 2 == 0) { // 1-1
            for (int i = 0; i < remainder; i++) {
                floors[i] = allHaveFloor + 1;
            }
        } else { // 1-2
            for (int i = 1; i <= remainder; i++) {
                floors[w - i] = allHaveFloor + 1;
            }
        }

        // 2
        int numFloor = ((num - 1) / w) + 1;
        int numW = (numFloor * w) - num;
        if (numFloor % 2 == 1) {
            numW = w - ((numFloor * w) - num) - 1;
        }

        // 3
        answer = floors[numW] - numFloor + 1;

        return answer;
    }
}

public class P389478 {
    public static void main(String[] args) {
        Solution389478 s = new Solution389478();

        System.out.println(s.solution(22, 6, 8));
        System.out.println(s.solution(13, 3, 6));
        System.out.println(s.solution(6, 5, 4));
    }
}