// https://www.acmicpc.net/problem/20440
// 20440: 🎵니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마🎵 - 1
package com.baekjoon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sujungeee {
    public static int N;
    public static List<int[]> times;

    public static void main(String[] args) throws IOException {
        times= new ArrayList<>();

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int entry= Integer.parseInt(st.nextToken());
            int exit= Integer.parseInt(st.nextToken());

            times.add(new int[] {entry, 1});
            times.add(new int[] {exit, -1});
        }

        times.sort((a, b) -> a[0] == b[0]
                ? Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]));

        int currentMosquitos = 0;
        int maxMosquitos = 0;
        int startTime = 0;
        int endTime = 0;
        boolean flag= false;

        for (int i=0; i<times.size(); i++) {
            currentMosquitos += times.get(i)[1];

            if (currentMosquitos > maxMosquitos) {
                // 최대 모기 개수 갱신
                maxMosquitos = currentMosquitos;
                startTime = times.get(i)[0];
                flag= true;
            }
            // 최대 모기 수를 지나고 나서, 모기 수가 줄어들면 구간 끝 시점 기록
            else if (currentMosquitos < maxMosquitos && flag) {
                if (i + 1 < times.size()
                        && times.get(i + 1)[0] == times.get(i)[0]
                        && times.get(i + 1)[1] == 1) {
                    continue;
                }
                endTime = times.get(i)[0];
                flag= false;
            }
        }

        System.out.println(maxMosquitos);
        System.out.println(startTime + " " + endTime);
    }
}