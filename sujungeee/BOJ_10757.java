// https://www.acmicpc.net/problem/10757
// 10757: 큰 수 A+B
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class BOJ_10757 {
    public static BigInteger a, b, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = new BigInteger(st.nextToken());
        b = new BigInteger(st.nextToken());

        answer = a.add(b);

        System.out.println(answer);
    }
}