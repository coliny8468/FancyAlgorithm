// https://www.acmicpc.net/problem/2742
// 2742: 기찍 N

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BOJ_2742 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        for(int i=N; i>=1; i--) {
            System.out.println(i);
        }
    }
}
