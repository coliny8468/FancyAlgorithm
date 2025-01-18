// https://www.acmicpc.net/problem/2668
// 2668: 숫자고르기

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class sujungeee {
    public static List<Integer> list;
    public static int N;
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        list= new ArrayList<>();

        N= Integer.parseInt(br.readLine());
        visited= new boolean[N+1];

        arr= new int[N+1];
        for(int i=1; i<N+1; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }

        for(int i=1; i<N+1; i++) {
            if (!visited[i]) {
                visited[i]= true;
                dfs(i, i);
                visited[i]= false;
            }
        }

        System.out.println(list.size());
        for(int i: list) {
            System.out.println(i);
        }
    }

    public static void dfs(int start, int idx) {
        if (arr[idx] == start) {
            list.add(start);
        }

        if (!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            dfs(start, arr[idx]);
            visited[arr[idx]] = false;
        }
    }
}