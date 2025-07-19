// https://school.programmers.co.kr/learn/courses/30/lessons/135807
package com.programmers.jul_2025;

/**
 * 135807: 숫자 카드 나누기
 * # summary
 * : 두 사람 중 한 사람만이 가지고 있는 모든 카드를 나눌 수 있는 가장 큰 수 구하기
 * # access
 * 1. 두 배열에서의 최대공약수를 구하기
 * 2. 하나의 큰 최대공약수가 다른 작은 최대공약수의 약수이면 답은 0
 *   ⇒ 큰 최대공약수가 작은 최대공약수의 배열의 카드를 나누면 조건을 만족할 수 없기 때문
 * 3. 위의 조건을 만족하지 않으면 각 최대공약수 중 큰 값을 return
 */

class Solution135807 {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int cardsNum = arrayA.length;

        // 1
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < cardsNum; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 2
        if (gcdA > gcdB) {
            for (int i = 0; i < cardsNum; i++) {
                if (arrayB[i] % gcdA == 0) return 0;
            }
        } else if (gcdA < gcdB) {
            for (int i = 0; i < cardsNum; i++) {
                if (arrayA[i] % gcdB == 0) return 0;
            }
        } else {
            return 0;
        }

        return Math.max(gcdA, gcdB);
    }
}

public class P135807 {
    public static void main(String[] args){
        Solution135807 s = new Solution135807();
        System.out.println(s.solution(new int[] {10, 17}, new int[] {5, 20}));
        System.out.println(s.solution(new int[] {10, 20}, new int[] {5, 17}));
        System.out.println(s.solution(new int[] {14, 35, 119}, new int[] {18, 30, 102}));
    }
}