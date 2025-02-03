// https://www.acmicpc.net/problem/17352
// 17352: 여러분의 다리가 되어 드리겠습니다!
package com.baekjoon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class sujungeee {
    public static int answer;
    public static int N;
    public static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        res= new int[N+1];
        for(int i=1; i<=N; i++){
            res[i]= i;
        }

        for(int i=1; i<=N-2; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int parent= find(1);
        for(int i= 2; i<= N; i++) {
            if (find(i) != parent) {
                answer= i;
                break;
            }
        }

        System.out.println(1 + " " + answer);
    }

    public static void union(int x, int y) {
        int rootX= find(x);
        int rootY= find(y);
        if (rootX != rootY) {
            res[rootY]= rootX;
        }
    }

    public static int find(int x) {
        if (res[x] != x) {
            res[x]= find(res[x]);
        }
        return res[x];
    }
}