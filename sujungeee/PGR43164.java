// https://school.programmers.co.kr/learn/courses/30/lessons/43164
package com.programmers.jun_2025;

import java.util.*;

class Solution43164 {
    List<String> answers;
    List<String[]> paths; // 티켓 경로
    int ticketCnt; // 티켓 개수
    boolean finished; // 티켓을 모두 사용했는지 여부
    boolean[] visited; // 티켓을 사용했는지 여부

    public String[] solution(String[][] tickets) {
        // 1
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            } else {
                return a[0].compareTo(b[0]);
            }
        });

        answers = new ArrayList<>();
        answers.add("ICN");
        paths = Arrays.asList(tickets);
        ticketCnt = tickets.length;
        finished = false;
        visited = new boolean[ticketCnt];

        recur("ICN", 0);

        return answers.toArray(new String[0]);
    }

    public void recur(String start, int cnt) {
        // 2-1
        if (cnt == ticketCnt) {
            finished = true;
            return;
        }

        // 2-2
        for (int i = 0; i < paths.size(); i++) {
            if (!visited[i] && paths.get(i)[0].equals(start)) {
                visited[i] = true;
                answers.add(paths.get(i)[1]);

                recur(paths.get(i)[1], cnt + 1);
                if (finished) return;

                visited[i] = false;
                answers.remove(answers.size() - 1);
            }
        }
    }
}

public class PGR43164 {
    public static void main(String[] args) {
        Solution43164 s = new Solution43164();

        System.out.println(Arrays.toString(s.solution(new String[][]{
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
        })));
        System.out.println(Arrays.toString(s.solution(new String[][]{
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
        })));
        System.out.println(Arrays.toString(s.solution(new String[][]{
                {"ICN", "BBB"}, {"BBB", "ICN"}, {"ICN", "AAA"}
        })));
    }
}