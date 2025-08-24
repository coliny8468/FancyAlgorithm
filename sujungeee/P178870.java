package com.programmers.aug_2025;

/**
 * 178870: 연속된 부분 수열의 합
 * # summary
 * : 연속된 부분 수열의 합이 k인 구간을 구하자!(단, 구간의 길이가 최소여야 하며, 최소인 구간이 여러 개라면 앞 구간을 출력하기)
 * # access
 * 1. dp.. 를 생각했으나 아무래도 값이 아닌 구간을 구하는 것이므로 적절치 않다고 판단
 * 2. "구간"의 합! 을 생각하다보니 투포인터를 활용하는 것으로 결정
 *     (+ 본 배열은 오름차순 정렬이 되어있으므로 포인터 조정으로 구간의 합을 모두 구할 수 있다.)
 * # logic
 * 1. 연속된 구간의 시작 인덱스인 left와 끝 인덱스인 right를 0으로, 연속된 구간의 합(value)을 첫 인덱스 값으로 초기화한다.
 * 2. 연속된 구간의 합이 k이면 구간의 길이를 구해, 최소 구간의 길이(minLength)보다 작으면 구간의 시작과 끝 인덱스를 갱신한다.
 *    (구간의 길이가 같으면 앞 구간을 구해야하므로 별다른 조취를 취하지 않는다.)
 * 3. 연속된 구간의 합이 k보다 크면 k보다 작아져야 하므로, 구간의 시작을 오른쪽으로 한 칸 민다.(기존 시작 값을 구간의 합에서 제외한다.)
 * 4. 연속된 부분 수열의 합이 k보다 작으면,
 *     4-1. 구간의 끝을 오른쪽으로 한 칸 민다.(단, 끝 포인터는 배열의 끝을 넘지 않아야 한다.)
 *     4-2. 구간의 끝이 배열의 끝에 도달하면, 더 이상 오른쪽으로 밀 수 없기 때문에 왼쪽을 한 칸 민다.
 *         (왼쪽마저 끝에 도달하면 더 이상 합이 k인 구간을 만들 수 없기 때문이다.)
 */

import java.util.Arrays;

class Solution178870 {
    int N;

    public int[] solution(int[] sequence, int k) {
        // 1
        int[] answer = new int[2];
        N = sequence.length;
        int left = 0;
        int right = 0;
        int value = sequence[0];
        int minLength = Integer.MAX_VALUE;

        while(left < N) {
            // 2
            if (value == k) {
                int length = right - left + 1;
                // 2-1
                if (length < minLength) {
                    answer[0] = left;
                    answer[1] = right;
                    minLength = length;
                }
                value -= sequence[left++];
            } else if (value > k) {
                // 3
                value -= sequence[left++];
            } else {
                // 4-1
                if (right + 1 < N) value += sequence[++right];
                    // 4-2
                else value -= sequence[left++];
            }
        }

        return answer;
    }
}

public class P178870 {
    public static void main(String[] args) {
        Solution178870 s = new Solution178870();

        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(s.solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }
}
