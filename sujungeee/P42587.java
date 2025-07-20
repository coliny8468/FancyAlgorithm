// https://school.programmers.co.kr/learn/courses/30/lessons/42587
package com.programmers.jul_2025;

/**
 * 42587: 프로세스
 * # summary
 * : 특정 프로세스가 몇 번째로 나오는지 구하기
 * # access
 * 1. 큐에 다 집어넣고, 특정 프로세스가 꺼내지면 우선순위를 return하기
 * 2. 이때 꺼낸 프로세스가 가장 큰 값이어야 하는데 이는 Collections.max()를 활용!
 * # logic
 * 1. 큐의 맨 앞에서 꺼낸 프로세스가 가장 큰 값이 아니라면 다시 큐에 넣는다.
 * 2. 가장 큰 값이면 프로세스를 실행시킨다.(answer +1)
 *   , 이 때 프로세스를 실행시킨 위치(location)가 0이라면 탐색을 중단시킨다.
 * 3. location을 앞으로 한 칸씩 땡긴다.
 */

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution42587 {
    List<Integer> pList;

    public int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        pList = new ArrayList<>();
        for (int priority : priorities) {
            queue.addLast(priority);
            pList.add(priority);
        }

        while(true) {
            int num = queue.pollFirst();

            if (hasBiggerNum(num)) {
                queue.addLast(num);
            } else {
                answer++;
                pList.remove(Integer.valueOf(num));
                if (location == 0) {
                    break;
                }
            }

            location = (location - 1 + queue.size()) % queue.size();
        }

        return answer;
    }

    boolean hasBiggerNum(int num) {
        return Collections.max(pList) != num;
    }
}

public class P42587 {
    public static void main(String[] args) {
        Solution42587 s = new Solution42587();

        System.out.println(s.solution(new int[] {2, 1, 3, 2}, 2));
        System.out.println(s.solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }
}