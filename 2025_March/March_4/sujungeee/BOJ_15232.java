// https://www.acmicpc.net/problem/15232
// 15232: Rectangle
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15232 {
    public static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}