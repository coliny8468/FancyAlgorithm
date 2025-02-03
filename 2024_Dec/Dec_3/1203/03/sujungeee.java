// https://www.acmicpc.net/problem/6497
// 6497: 전력난
package com.baekjoon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class sujungeee {
    static int m;
    static int n;
    static Node[] info;
    static int[] relationships;
    static int total; // 전체 소지 액수
    static int answer; // total - 최소 소비 액수

    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        Node(int start, int end, int cost) {
            this.start= start;
            this.end= end;
            this.cost= cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            m= Integer.parseInt(st.nextToken());
            n= Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            // 0-1. 노드 정보 저장
            info= new Node[n];
            total= 0;
            for (int i=0; i<n; i++) {
                st= new StringTokenizer(br.readLine());
                int start= Integer.parseInt(st.nextToken());
                int end= Integer.parseInt(st.nextToken());
                int cost= Integer.parseInt(st.nextToken());
                info[i]= new Node(start, end, cost);
                total+= cost;
            }

            // 0-2. 노드 간의 관계 배열 초기화
            relationships= new int[m];
            for(int i=0; i<m; i++) {
                relationships[i]= i;
            }

            // 1. 간선을 기준으로 오름차순 정렬하기
            Arrays.sort(info);

            // 2. 크루스칼 알고리즘
            kruskal(0);
            System.out.println(answer);
        }
    }

    public static int find(int node){
        if (relationships[node] == node) {
            return node;
        }
        return find(relationships[node]);
    }

    public static void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent1 != parent2) {
            relationships[parent2] = parent1;
        }
    }

    public static void kruskal(int costs) {
        int cnt= 0;
        for(Node node: info){
            if (cnt == m-1) break;

            int parent1= find(node.start);
            int parent2= find(node.end);

            if (parent1 != parent2) {
                cnt++;
                costs+= node.cost;
                union(node.start, node.end);
            }
        }

        answer= total - costs;
    }
}