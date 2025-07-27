// https://www.acmicpc.net/problem/13905
package com.baekjoon.jul_2025;

/**
 * 13905: 세부
 * # summary
 * : 경로 상에서 들고갈 수 있는 최대 빼빼로의 개수를 구하자.
 * # access(크루스칼 알고리즘)
 * 1. 무게가 큰 다리부터 경로를 만들 수 있도록 "우선순위 큐에 큰 무게가 우선인 Info"를 삽입
 * 2. 두 위치와 다리 무게 정보(Info)로 경로를 생성 by (union - find)
 * 3. 출발지부터 목적지를 잇는 경로가 완성되면 그 때의 무게를 return 하기
 *   (이유: 큰 무게의 다리를 먼저 잇기 때문에 마지막 다리가 이어지면 그 값이 지닐 수 있는 최대 빼빼로의 개수가 되기 때문)
 * # logic
 * 1. 자식(v 위치)을 인덱스, 부모(u 위치)를 값으로 두어 자식 - 부모 관계를 만드는 parent를 초기화한다.
 * 2. 우선순위 큐에 두 위치와 무게 정보(Info)를 삽입한다.
 * 3. 우선순위 큐에서 무게가 가장 큰 Info를 추출하여, 경로를 생성한다.(by union())
 *    이후, 출발지와 목적지를 잇는 경로가 완성되면 -> 해당 경로 상의 무게를 answer에 저장한다.
 * 4. union(): 두 위치의 시작점을 부모 - 자식으로 잇는다.(by find(), parent)
 * 5. find(): 위치의 시작점을 return한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B13905 {
    static int N, M;
    static int start, end;
    static int[] parent;
    static PriorityQueue<Info> pq;

    static class Info implements Comparable<Info>{
        int u, v, cost;

        Info(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Info other) {
            return Integer.compare(other.cost, this.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 1
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 2
        pq = new PriorityQueue<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Info(u, v, cost));
        }

        // 3
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            union(info.u, info.v);

            if (find(start) == find(end)) {
                answer = info.cost;
                break;
            }
        }

        System.out.println(answer);
    }

    // 4
    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        parent[parentB] = parentA;
    }

    // 5
    static int find(int a) {
        if (parent[a] == a) return a;
        return find(parent[a]);
    }
}