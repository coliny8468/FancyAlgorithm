// https://www.acmicpc.net/problem/1057
// 1057: 토너먼트
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057 {
    public static int N, p1, p2;
    public static int answer;

    public static void main(String[] args) throws IOException {
        answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        while(Math.abs(p1 - p2) != 1 || Math.min(p1, p2) % 2 == 0) {
            if (p1 % 2 == 0) {
                p1 = p1 / 2;
            } else{
                p1 = (p1 / 2) + 1;
            }

            if (p2 % 2 == 0) {
                p2 = p2 / 2;
            } else{
                p2 = (p2 / 2) + 1;
            }
            answer++;
        }
        System.out.println(answer);
    }
}