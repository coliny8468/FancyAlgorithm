// https://school.programmers.co.kr/learn/courses/30/lessons/250121#
package com.programmers.aug_2025;

/**
 * 250121: [PCCE 기출문제] 10번 / 데이터 분석
 * # summary
 * : val_ext보다 작은 ext들을 sort_by 순으로 오름차순 정렬하기
 * # access
 * : 구현!
 * => 조건 필터링 후 오름차순 정렬하기
 * # logic
 * 1. for문으로 조건 필터링하여 answer List에 담은 후 정렬하기
 * 2. stream의 filter로 조건을 필터링하고 sorted로 정렬하기
 * 3. data List에서 val_ext보다 큰 데이터를 제거한 후 정렬하기
 */

import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution250121_1 {
    Map<String, Integer> columns = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
    List<int[]> answer;

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        answer = new ArrayList<>();

        int conditionIdx = columns.get(ext);
        for (int[] d : data) {
            if (d[conditionIdx] < val_ext) {
                answer.add(d);
            }
        }

        int sortIdx = columns.get(sort_by);
        answer.sort((a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));
        return answer.toArray(new int[0][]);
    }
}

class Solution250121_2 {
    Map<String, Integer> columns = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
    List<int[]> answer;

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int conditionIdx = columns.get(ext);
        int sortIdx = columns.get(sort_by);

        return Arrays.stream(data)
                .filter(d -> d[conditionIdx] < val_ext)
                .sorted((a, b) -> Integer.compare(a[sortIdx], b[sortIdx]))
                .toArray(int[][]::new);
    }
}

class Solution250121_3 {
    Map<String, Integer> columns = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
    List<int[]> answer;

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int conditionIdx = columns.get(ext);
        int sortIdx = columns.get(sort_by);
        answer = new ArrayList<>(Arrays.asList(data));

        answer.removeIf(d -> d[conditionIdx] >= val_ext);

        answer.sort((a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));

        return answer.toArray(new int[0][]);
    }
}

public class P250121 {
    public static void main(String[] args) {
        Solution250121_1 s = new Solution250121_1();

        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}
                , "date", 20300531, "remain"
        )));
    }
}