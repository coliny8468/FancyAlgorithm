// https://www.acmicpc.net/problem/5557
// 5557: 1학년

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class sujungeee {
    static int N;
    static int[] arrays;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        arrays= new int[N];
        for(int i=0; i<N; i++){
            arrays[i]= Integer.parseInt(st.nextToken());
        }

        dp= new long[N-1][21];
        dp[0][arrays[0]]= 1;
        for (int i=1; i<N-1; i++) {
            for (int num = 0; num <= 20; num++) {
                if (num-arrays[i] >= 0){
                    dp[i][num]+= dp[i-1][num-arrays[i]];
                }
                if (num+arrays[i] <= 20) {
                    dp[i][num]+= dp[i-1][num+arrays[i]];
                }
            }
        }
        System.out.println(dp[N-2][arrays[N-1]]);
    }

    public static class BOJ_5558 {
    }
}

