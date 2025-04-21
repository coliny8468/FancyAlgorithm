// http://acmicpc.net/problem/2475
// 2475: 검증수

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2475 {
    public static int answer;

    public static void main(String[] args) throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            answer += tmp*tmp;
        }
        System.out.println(answer % 10);
    }
}