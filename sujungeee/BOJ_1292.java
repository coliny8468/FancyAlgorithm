// https://www.acmicpc.net/problem/2506
// 2506: 점수 계산
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2506 {
    public static int N, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        int score = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 1) {
                score++;
                answer += score;
            } else {
                score = 0;
            }
        }
        System.out.print(answer);
    }
}