// https://school.programmers.co.kr/learn/courses/30/lessons/176962
package com.programmers.aug_2025;

/**
 * 176962: 과제 진행하기
 * # summary
 * : 과제가 끝난 순서를 구하기
 * # access
 * : 자료구조를 이용한 구현!!
 * => ArrayDeque(과제 대기 줄)을 이용
 * # logic
 * 1. 시간이 이른 과제부터 수행해야 하므로 "과제 시작 시간"의 오름차순으로 정렬한 후,
 *    새로운 과제 대기 줄(remains)에 과제들을 모두 추가한다.
 *     * remains- 시작하지 않은 새로운 과제 대기 줄, paused- 끝나지 않은 과제 대기 줄
 * 2. 모든 과제가 끝날 때까지, 해당 로직을 수행한다.
 *     2-1. 새로운 과제가 모두 끝나지 않았다면, 시작할 과제를 꺼낸다.
 *         2-1-1. 다음 과제가 있다면, 다음 과제 시작 전까지 현재 꺼낸 과제를 수행한다.
 *                현재 꺼낸 과제를 다음 과제 시작 전까지 모두 수행하지 못하면 (remainTime > 0)
 *                -> 해당 과제를 끝나지 않은 과제 대기 줄(paused) 끝에 세운다.
 *                현재 꺼낸 과제를 다음 과제 시작 전까지 모두 수행한다면
 *                -> 끝나지 않은 과제 대기 줄(paused) 중 최근의 멈춘 과제부터 다음 과제 시작 시간까지 수행한다.
 *                   (최근의 멈춘 과제를 모두 수행하면 과제를 끝내고 answer에 추가한다.)
 *         2-2-2. 다음 과제가 없다면, 해당 과제가 마지막 과제이므로 과제를 끝내고 answer에 추가한다.
 *     2-2. 새로운 과제가 모두 끝났다면 -> 끝나지 않은 과제 대기 줄 중 가장 최근에 멈춘 과제부터 과제를 끝내고 answer에 추가한다.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution176962 {
    ArrayDeque<String[]> remains;
    ArrayDeque<String[]> paused;
    int N;

    public int toMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    public String[] solution(String[][] plans) {
        N = plans.length;
        String[] answer = new String[N];
        int idx = 0;

        // 1
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
        remains = new ArrayDeque<>();
        paused = new ArrayDeque<>();
        for (String[] plan : plans) {
            remains.addLast(plan);
        }

        // 2
        while (!remains.isEmpty() || !paused.isEmpty()) {
            String[] plan;
            int startTime;
            int finishTime;

            // 2-1
            if (!remains.isEmpty()) {
                plan = remains.pollFirst();
                startTime = toMinutes(plan[1]);
                finishTime = startTime + Integer.parseInt(plan[2]);

                if (!remains.isEmpty()) {
                    // 2-1-1
                    String[] nextPlan = remains.peekFirst();
                    int nextStart = toMinutes(nextPlan[1]);
                    int remainTime = Integer.parseInt(plan[2]) - (nextStart - startTime);

                    if (remainTime > 0) {
                        paused.addLast(new String[]{plan[0], nextPlan[1], remainTime + ""});
                    } else {
                        answer[idx++] = plan[0];

                        int curTime = finishTime;
                        while (!paused.isEmpty() && curTime < nextStart) {
                            String[] p = paused.pollLast();
                            int pRemain = Integer.parseInt(p[2]);
                            int pFinish = curTime + pRemain;
                            if (pFinish > nextStart) {
                                int left = nextStart - curTime;
                                paused.addLast(new String[]{p[0], nextPlan[1], (pRemain - left) + ""});
                                break;
                            } else {
                                answer[idx++] = p[0];
                                curTime = pFinish;
                            }
                        }
                    }
                } else {
                    answer[idx++] = plan[0];
                }
            } else {
                // 2-2
                String[] p = paused.pollLast();
                answer[idx++] = p[0];
            }
        }

        return answer;
    }
}

public class P176962 {
    public static void main(String[] args) {
        Solution176962 s = new Solution176962();

        System.out.println(Arrays.toString(s.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));
        System.out.println(Arrays.toString(s.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
        System.out.println(Arrays.toString(s.solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}})));
    }
}
