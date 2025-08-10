// https://www.acmicpc.net/problem/20040
package com.baekjoon.aug_2025;

/**
 * 20040: 사이클 게임
 * # summary
 * : 주어진 진행 상황으로 몇 번째 차례에 싸이클이 완성되는지 구하기
 *   (싸이클이 만들어지지 않으면 0이 답)
 * # access
 * : union-find
 * 1. union: 두 노드의 루트 노드가 다르면 싸이클 없이 그래프를 형성한다.
 * 2. find: 한 노드의 루트 노드를 반환한다.
 * # logic
 * (편의상 점을 노드라 칭함)
 * 1. 두 노드의 루트 노드를 find()로 찾는다.
 *    find(): 자식 노드가 인덱스, 부모 노드가 값이므로 -> 부모 노드를 인덱스로 재귀 호출하여 루트 노드를 찾는다.
 * 2. 두 루트 노드가 다르면 싸이클을 형성하지 않으므로 두 노드를 연결한다.
 *    두 루트 노드가 같으면 두 노드를 연결하였을 때 사이클이 형성되므로, 현재 차례를 answer에 저장하고 탐색을 중지한다.
 * 3. answer를 출력한다. 만약 모든 게임 상황에서 싸이클이 형성되지 않았다면 본래 값인 0이 출력될 것이다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20040 {
    static int n, m;
    static int[] rel;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rel = new int[n];
        for (int i = 0; i < n; i++) rel[i] = i;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 1
            int startRoot = find(start);
            int endRoot = find(end);

            // 2
            if (startRoot != endRoot) {
                union(startRoot, endRoot);
            } else {
                answer = i;
                break;
            }
        }

        // 3
        System.out.println(answer);
    }

    public static void union(int node1, int node2) {
        rel[node2] = node1;
    }

    public static int find(int node) {
        if (rel[node] == node) return node;
        return find(rel[node]);
    }
}