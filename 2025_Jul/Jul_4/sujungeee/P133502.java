// https://school.programmers.co.kr/learn/courses/30/lessons/133502
package com.programmers.jul_2025;

/**
 * 133502: 햄버거 만들기
 * # summary
 * : 상수가 만들 수 있는 햄버거의 개구를 구하자
 * # access
 * : 스택을 이용하여 (1, 2, 3, 1) 햄버거가 완성되면 햄버거의 개수를 +1 하고 재료들을 빼내기
 * # logic
 * 1. 스택에 햄버거 재료를 넣는다.
 * 2. 스택에서 4개의 햄버거 재료를 빼낸다.
 * 3. 빼낸 햄버거 재료들이 원 순서의 반대인 (1, 3, 2, 1)과 같다면 햄버거가 완성되므로 개수를 +1
 *   (반대 순서로 재료들을 꺼냈으므로)
 * 4. 빼낸 햄버거의 재료들이 (1, 3, 2, 1)과 같지 않다면 다시 햄버거 재료들을 스택에 넣는다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution133502 {
    List<Integer> ingredients = Arrays.asList(1, 3, 2, 1);

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            // 1
            stack.add(i);

            // 2
            List<Integer> hamburger = new ArrayList<>();
            int idx = 0;
            while (!stack.isEmpty() && idx <= 3) {
                hamburger.add(stack.pop());
                idx++;
            }

            if (hamburger.equals(ingredients)) {
                // 3
                answer++;
            } else {
                // 4
                for (int j = hamburger.size() - 1; j >= 0; j-- ) stack.add(hamburger.get(j));
            }
        }

        return answer;
    }
}

//class Solution133502 {
//    public int solution(int[] ingredient) {
//        int answer = 0;
//
//        int[] stack = new int[ingredient.length];
//        int idx = 0;
//
//        for (int i : ingredient) {
//            stack[idx++] = i;
//            if (idx >= 4 && stack[idx - 1] == 1 && stack[idx - 2] == 3 && stack[idx - 3] == 2 && stack[idx - 4] == 1) {
//                idx -= 4;
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//}


public class P133502 {
    public static void main(String[] args) {
        Solution133502 s = new Solution133502();

        System.out.println(s.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(s.solution(new int[] {1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}