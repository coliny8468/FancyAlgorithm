
// https://www.acmicpc.net/problem/2922
package com.baekjoon.aug_2025;

/**
 * 2922: 즐거운 단어
 * # summary
 * : 즐거운 단어를 만들 수 있는 경우의 수를 세자
 * # access
 * 1. 단어에 L이 있는지 없는지 판단하여, L이 없다면 "_"에 L을 무조건 하나는 넣어야 한다!
 * 2. 밑줄의 앞뒤로 2칸씩 포함하여 자음과 모음이 3연속 나란히 나오지 않아야 한다.
 * # logic
 * 1. recur(): 밑줄에 조건을 충족하는 모음 또는 자음이 올 수 있는 경우의 수를 탐색하는 함수
 *     1-1. 단어가 다 완성되고, "L"이 포함되면(isContained가 true이면) 자음과 모음의 경우의 수 결과(count)를 answer에 더한다.
 *     1-2. 탐색하는 값이 "_"이 아니면 다음 인덱스로 넘어간다.
 *     1-3. "_"에 모음이 들어갔을 때, 연속된 문자열이 없다면 5가지 모음의 경우의 수를 곱하고 다음 인덱스로 넘어간다.
 *     1-4. "_"에 L을 제외한 자음이 들어갔을 때, 연속된 문자열이 없다면 20가지 모음의 경우의 수를 곱하고 다음 인덱스로 넘어간다.
 *          => 1-3, 1-4 경우는 L을 넣지 않았으므로 isContained를 그대로 다음 호출의 인자로 넘긴다.
 *     1-5. "_"에 L이 들어갔을 때, 연속된 문자열이 없다면 isContained를 true로 설정하고 다음 인덱스로 넘어간다.
 * 2. isContinuous(): 특정 인덱스로부터 모음 또는 자음이 연속해서 3번 나오는지 확인하는 함수
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2922 {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static long answer;
    static String str;
    static int length;

    public static void main(String[] args) throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        length = str.length();

        recur(0, str.toCharArray(), str.contains("L"), 1L);
        System.out.println(answer);
    }

    // 1
    static void recur(int idx, char[] arr, boolean isContained, long count) {
        // 1-1
        if (idx == length) {
            if (isContained) answer += count;
            return;
        }

        // 1-2
        if (arr[idx] != '_') {
            recur(idx + 1, arr, isContained, count);
        } else {
            // 1-3
            arr[idx] = 'A'; // 모음
            if (!isContinuous(idx, arr)) {
                recur(idx + 1, arr, isContained, count * 5);
            }

            // 1-4
            arr[idx] = 'B'; // L 제외 자음
            if (!isContinuous(idx, arr)) {
                recur(idx + 1, arr, isContained, count * 20);
            }

            // 1-5
            arr[idx] = 'L';
            if (!isContinuous(idx, arr)) {
                recur(idx + 1, arr, true, count);
            }

            arr[idx] = '_';
        }
    }

    // 2
    static boolean isContinuous(int idx, char[] arr) {
        for (int i = idx - 2; i <= idx; i++) {
            int vowelCount = 0;
            int etcCount = 0;
            if (i >= 0 && i + 2 < length) {
                for (int j = 0; j < 3; j++) {
                    for (char s : vowels) {
                        if (arr[i + j] == s){
                            vowelCount++;
                            break;
                        }
                    }
                    if (arr[i + j] == '_') etcCount++;
                }
                int consCount = 3 - vowelCount - etcCount;
                if (consCount == 3 || vowelCount == 3) return true;
            }
        }
        return false;
    }
}
