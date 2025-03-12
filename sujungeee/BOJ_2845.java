// https://www.acmicpc.net/problem/2845ㄴ
// 2845: 파티가 끝나고 난 뒤
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int L, P;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int cnt = L*P;

        array = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(st.nextToken()) - cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int i: array) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}