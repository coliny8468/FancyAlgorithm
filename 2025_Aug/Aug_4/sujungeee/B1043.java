package com.baekjoon.aug_2025;

/**
 * 1043: 거짓말
 * # summary
 * : 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하기
 * # access
 * 1. "진실을 아는 사람" or "진실을 아는 사람과 함께 있는 사람"이 있는 파티의 수를 제외해야 한다.
 * => 진실을 아는 사람이 속한 파티의 파티원들은 다른 파티에서도 진실을 알릴 수 있다! (좀비가 전염되듯이...)
 * # logic
 * 1. 진실을 아는 사람들(trues), 파티원이 있는 파티 정보(parties)를 HashSet과 List에 저장한다.
 * 2. 진실을 알지 못하는 파티만 남을 때까지 searchAll()를 호출한다.
 * 3. searchAll(): 진실을 아는 사람들을 모두 파티에서 제외하는 함수
 *     3-1. 파티들을 모두 탐색하면서 해당 파티에 진실을 아는 사람이 있는지 확인한다.
 *     3-2. 진실을 아는 사람이 있다면 -> trues에 해당 파티의 파티원들을 모두 추가하고 해당 파티를 parties에서 제외시킨다.
 *          진실을 아는 사람이 아직 존재하므로 false를 return한다.
 * 4. 진실을 알지 못하는 파티 수를 출력한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B1043 {
    static int N, M;
    static int trueCnt;
    static Set<Integer> trues;
    static int answer;
    static List<List<Integer>> parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1-1
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = M;
        parties = new ArrayList<>();

        // 1-2
        st = new StringTokenizer(br.readLine());
        trueCnt = Integer.parseInt(st.nextToken());
        trues = new HashSet<>();
        for (int i = 0; i < trueCnt; i++) {
            trues.add(Integer.parseInt(st.nextToken()));
        }

        // 1-3
        for (int i = 0; i < M; i++) {
            List<Integer> people = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= cnt; j++) people.add(Integer.parseInt(st.nextToken()));
            parties.add(people);
        }

        // 2
        while (true) {
            if (searchAll()) break;
        }

        // 4
        System.out.println(parties.size());
    }

    // 3
    public static boolean searchAll() {
        for (int i = 0; i < parties.size(); i++) {
            // 3-1
            boolean isKnown = false;
            for (Integer person : parties.get(i)) {
                if (isKnown || trues.contains(person)) {
                    isKnown = true;
                    break;
                }
            }

            // 3-2
            if (isKnown) {
                for (Integer person : parties.get(i)) trues.add(person);
                parties.remove(i);
                return false;
            }
        }
        return true;
    }
}