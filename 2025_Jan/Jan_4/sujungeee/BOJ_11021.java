// https://www.acmicpc.net/problem/11021
// 11021: A + B - 7

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11021 {
    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int result= a + b;
            System.out.println("Case #" + i + ": " + result);
        }
    }
}