// https://www.acmicpc.net/problem/1032
// 1032: 문자열
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1032 {
    public static int N;
    public static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int len = arr[0].length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            char c = arr[0].charAt(i);
            for(int j = 1; j < N; j++) {
                if (c != arr[j].charAt(i)) flag = false;
            }

            if (flag) {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }
        System.out.println(sb);
    }
}
