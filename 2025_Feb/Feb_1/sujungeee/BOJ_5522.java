// https://www.acmicpc.net/problem/5522
// 5522: 카드 게임
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5522 {
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        for (int i = 0; i < 5; i++) {
            answer += Integer.parseInt(br.readLine());
        }

        System.out.println(answer);
    }
}