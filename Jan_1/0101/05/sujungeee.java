// https://www.acmicpc.net/problem/12865
// 12865: 평범한 배낭

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class sujungeee {
    public static int N, K;
    public static int[] dp;
    public static product[] products;

    public static class product {
        int weight;
        int value;

        product(int weight, int value) {
            this.weight= weight;
            this.value= value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        products= new product[N];
        for(int i=0; i<N; i++) {
            st= new StringTokenizer(br.readLine());
            int weight= Integer.parseInt(st.nextToken());
            int value= Integer.parseInt(st.nextToken());
            products[i]= new product(weight, value);
        }

        dp= new int[K+1];
        for(int i=0; i<N; i++) {
            for (int j=K; j>= products[i].weight; j--) {
                dp[j]= Math.max(dp[j], dp[j - products[i].weight] + products[i].value);
            }
        }

        System.out.println(dp[K]);
    }
}