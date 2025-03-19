// https://www.acmicpc.net/problem/13424
// 13424: 비밀 모임

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class sujungeee {
    public static int test_case;
    public static int N, M, K;
    public static int[][] costs;
    public static int[] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        test_case = Integer.parseInt(br.readLine());
        for(int i = 0; i < test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // cost 배열 초기화
            costs = new int[N+1][N+1];
            for (int j = 1; j <= N; j++){
                Arrays.fill(costs[j], N*N*1000);
            }

            for (int j = 1; j <= N; j++) {
                costs[j][j] = 0;
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                costs[start][end] = cost;
                costs[end][start] = cost;
            }

            K = Integer.parseInt(br.readLine());
            info = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                info[j] = Integer.parseInt(st.nextToken());
            }

            floyd_warshall();
        }
    }

    public static void floyd_warshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }

        List<Integer> minInfo = new ArrayList<>();
        int minCost = N*N*1000;
        for(int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 0; j < K; j++) {
                tmp += costs[i][info[j]];
            }

            if (tmp < minCost) {
                minCost = tmp;
                minInfo.clear();
                minInfo.add(i);
            } else if (tmp == minCost) {
                minInfo.add(i);
            }
        }

        Collections.sort(minInfo);
        System.out.println(minInfo.get(0));
    }
}