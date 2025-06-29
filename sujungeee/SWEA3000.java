// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-fO0s6ARoDFAXT&categoryId=AV-fO0s6ARoDFAXT&categoryType=CODE&problemTitle=%EC%A4%91%EA%B0%84%EA%B0%92&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
package com.swea.course.jun_2025;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA3000 {
    static PriorityQueue<Integer> minQueue;
    static PriorityQueue<Integer> maxQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= N; testCase++) {
            long answer = 0;

            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>(Collections.reverseOrder());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int medium = Integer.parseInt(st.nextToken());
            minQueue.add(medium);

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if (num1 < medium && num2 < medium) {
                    // 2-1
                    maxQueue.add(num1);
                    maxQueue.add(num2);
                    medium = maxQueue.poll();
                    minQueue.add(medium);
                } else if (num1 > medium && num2 > medium) {
                    // 2-2
                    minQueue.add(num1);
                    minQueue.add(num2);
                    maxQueue.add(minQueue.poll());
                    medium = minQueue.peek();
                } else if ((num1 > medium && num2 < medium) || (num1 < medium && num2 > medium)) {
                    // 2-3
                    int min = Math.min(num1, num2);
                    int max = Math.max(num1, num2);
                    maxQueue.add(min);
                    minQueue.add(max);
                }

                answer += medium;
                answer %= 20171109;
            }

            System.out.printf("#%d %d\n", testCase, answer);
        }
    }
}