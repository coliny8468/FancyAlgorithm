// https://www.acmicpc.net/problem/10953
// 10953: A + B - 6

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10953 {
    static int T;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] input = br.readLine().split(",");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            System.out.println(a+b);
        }
    }
}
